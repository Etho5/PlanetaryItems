package com.etho5.PlanetaryItems.objects;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Collections;

public enum PlanetItems {

    SECTITE("Little green flakes of magic and mystery.", "Carbocera", 112),
    UNREFINED_CARBON("Like coal, but better.", Material.COAL, "Carbocera", 113),
    MAGMA_CORE("Power lives inside this stone, deep inside.", "Kara", 114),
    MARAN_DUST("Don't get too touchy, you might get tetanus.", "Kara", 115),
    GLACIAL_CORE("Cold, cloudy, and shining like a star.", "Hothura", 116),
    ;

    private final WorldItem item;
    private final String planetName;

    PlanetItems(String description, String planetFrom, int customModelData) {
        this.item = new WorldItem(Material.CLOCK, 1, Collections.singletonList(ChatColor.DARK_GREEN + description), customModelData);
        this.planetName = planetFrom;
    }

    PlanetItems(String description, Material type, String planetFrom, int customModelData) {
        this.item = new WorldItem(type, 1, Collections.singletonList(ChatColor.DARK_GREEN + description), customModelData);
        this.planetName = planetFrom;
    }

    public WorldItem getItem() {
        return this.item;
    }

    public String getPlanetName() {
        return this.planetName;
    }
}
