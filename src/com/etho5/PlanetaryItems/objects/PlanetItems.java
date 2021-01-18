package com.etho5.PlanetaryItems.objects;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public enum PlanetItems {

    SECTITE(
            ChatColor.GREEN + "Sectite",
            Arrays.asList(ChatColor.GRAY + "Little green flakes of magic and mystery.", ChatColor.DARK_GREEN + "Planet of origin: " + ChatColor.GREEN + "Carbocera"),
            "Carbocera",
            536112),
    UNREFINED_CARBON(
            ChatColor.DARK_GRAY + "Unrefined Carbon",
            Arrays.asList(ChatColor.GRAY + "Like coal, but better.", ChatColor.DARK_GREEN + "Planet of origin: " + ChatColor.GREEN + "Carbocera"),
            Material.COAL,
            "Carbocera",
            536113),
    MAGMA_CORE(
            ChatColor.GOLD + "Magma Core", Arrays.asList(ChatColor.GRAY + "Power lives in this stone, trapped deep within.", ChatColor.DARK_GREEN + "Planet of origin: " + ChatColor.GREEN + "Kara"),
            "Kara",
            536114),
    MARAN_DUST(
            ChatColor.RED + "Maran Dust",
            Arrays.asList(ChatColor.GRAY + "Don't get too touchy, you might get tetanus.", ChatColor.DARK_GREEN + "Planet of origin: " + ChatColor.GREEN + "Kara"),
            "Kara",
            536115),
    GLACIAL_CORE(
            ChatColor.AQUA + "Glacial Core",
            Arrays.asList(ChatColor.GRAY + "Cold, cloudy, and shining like a star.", ChatColor.DARK_GREEN + "Planet of origin: " + ChatColor.GREEN + "Hothura"),
            "Hothura",
            536116)
    ;

    private final WorldItem item;

    PlanetItems(String displayName, List<String> description, String planetFrom, int customModelData) {
        this.item = new WorldItem(Material.CLOCK, 1, displayName, description, customModelData);
    }

    PlanetItems(String displayName, List<String> description, Material type, String planetFrom, int customModelData) {
        this.item = new WorldItem(type, 1, displayName, description, customModelData);
    }

    public WorldItem getItem() {
        return this.item;
    }
}
