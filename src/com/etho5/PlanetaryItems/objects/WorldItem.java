package com.etho5.PlanetaryItems.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class WorldItem extends ItemStack {

    public WorldItem(Material type, int amount, List<String> lore, int customModelData) {
        super(type, amount);
        ItemMeta meta = this.getItemMeta();
        meta.setLore(lore);
        meta.setCustomModelData(customModelData);
        this.setItemMeta(meta);
    }
}
