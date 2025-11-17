package org.dimasik.menus.implementation;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public interface IMenu extends InventoryHolder {
    default @NotNull Inventory getInventory(){ return getCachedInventory(); }
    IMenu setPlayer();
    Player getViewer();
    IMenu compile();
    Inventory getCachedInventory();
    void open();
    void close();
}
