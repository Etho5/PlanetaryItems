package com.etho5.PlanetaryItems.utils;

import com.etho5.PlanetaryItems.objects.PlanetItems;
import com.etho5.PlanetaryItems.objects.WorldItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public Utils() {
        throw new AssertionError();
    }

    /**
     * Gets the appropriate item to drop from specific blocks broken on specific worlds.
     * @param sourceBlock the block being mined
     * @param planet the world the block is in
     * @param dropChance the chance an item (excluding sectite) will be dropped
     * @return the appropriate WorldItem drop, or null if nothing special should be dropped
     */
    public static WorldItem getPlanetDrop(Block sourceBlock, World planet, int dropChance) {
        String name = planet.getName();
        switch(name) {
            case "Kara":
                if(sourceBlock.getType() == Material.MAGMA_BLOCK) {
                    if(ThreadLocalRandom.current().nextInt(dropChance) == 1) return PlanetItems.MAGMA_CORE.getItem();
                } else if(sourceBlock.getType() == Material.RED_SAND) {
                    if(ThreadLocalRandom.current().nextInt(dropChance) == 1) return PlanetItems.MARAN_DUST.getItem();
                }
                break;
            case "Hothura":
                if(sourceBlock.getType() == Material.PACKED_ICE) {
                    if (ThreadLocalRandom.current().nextInt(dropChance) == 1) return PlanetItems.GLACIAL_CORE.getItem();
                }
                break;
            case "Carbocera":
                if(sourceBlock.getType() == Material.EMERALD_ORE) {
                    return PlanetItems.SECTITE.getItem();
                } else if(sourceBlock.getType() == Material.COAL_ORE) {
                    if (ThreadLocalRandom.current().nextInt(dropChance) == 1) return PlanetItems.UNREFINED_CARBON.getItem();
                }
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * Sends a help message for PlanetaryItems to the given CommandSender.
     * @param sender the person sending the command, who will receive the help message
     */
    public static void sendHelpMessage(final CommandSender sender) {
        sender.sendMessage(ChatColor.DARK_PURPLE + "----- " + ChatColor.BOLD + "PlanetaryItems" + ChatColor.DARK_PURPLE + " -----");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.YELLOW + "List: " + ChatColor.GREEN + "/pitems list");
        sender.sendMessage("");
        if (sender.hasPermission("planetaryitems.*")) {
            sender.sendMessage(ChatColor.YELLOW + "Give: " + ChatColor.GREEN + "/pitems give <player> <item>");
        }
    }
}
