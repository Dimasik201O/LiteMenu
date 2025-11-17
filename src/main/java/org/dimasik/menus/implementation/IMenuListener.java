package org.dimasik.menus.implementation;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

public interface IMenuListener extends Listener {
    void onClick(InventoryClickEvent event);
    void onClose(InventoryCloseEvent event);
    void register(JavaPlugin plugin);
}
