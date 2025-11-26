package org.dimasik.menus.implementation;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

public interface IMenuListener extends Listener {
    @EventHandler
    void onClick(InventoryClickEvent event);
    @EventHandler
    void onClose(InventoryCloseEvent event);
    void register(JavaPlugin plugin);
}
