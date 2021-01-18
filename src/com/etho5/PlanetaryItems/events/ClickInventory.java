package com.etho5.PlanetaryItems.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickInventory implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onInventoryClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equals("Planetary Items")) {
            e.setCancelled(true);
        }
    }
}
