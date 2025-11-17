package org.dimasik.menus.inheritance;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.dimasik.menus.implementation.IMenuListener;

import java.util.concurrent.CompletableFuture;

public abstract class MenuListener implements IMenuListener {
    private final Class<Menu> source;
    private final JavaPlugin plugin;
    private final boolean async;

    public MenuListener(Class<Menu> source, JavaPlugin plugin, boolean async){
        this.source = source;
        this.plugin = plugin;
        this.async = async;
    }

    protected abstract void onClick(InventoryClickEvent event, Menu menu, Player player, int slot);
    protected abstract void onClose(InventoryCloseEvent event, Menu menu, Player player);

    @Override
    public final void onClick(InventoryClickEvent event) {
        Inventory inventory = event.getView().getTopInventory();
        InventoryHolder holder = inventory.getHolder();
        if(source.isInstance(holder)){
            Menu menu = source.cast(holder);
            event.setCancelled(true);
            if(event.getClickedInventory() == null || event.getClickedInventory() != inventory)
                return;
            Player player = (Player) event.getWhoClicked();
            int slot = event.getSlot();
            if(!async)
                onClick(event, menu, player, slot);
            else
                CompletableFuture.runAsync(() -> onClick(event, menu, player, slot));
        }
    }

    @Override
    public final void onClose(InventoryCloseEvent event) {
        Inventory inventory = event.getView().getTopInventory();
        InventoryHolder holder = inventory.getHolder();
        if(source.isInstance(holder)) {
            Menu menu = source.cast(holder);
            Player player = (Player) event.getPlayer();
            if(!async)
                onClose(event, menu, player);
            else
                CompletableFuture.runAsync(() -> onClose(event, menu, player));
        }
    }

    @Override
    public final void register(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public final void register(){
        register(plugin);
    }
}
