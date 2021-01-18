package com.etho5.PlanetaryItems.commands;

import com.etho5.PlanetaryItems.objects.PlanetItems;
import com.etho5.PlanetaryItems.objects.WorldItem;
import com.etho5.PlanetaryItems.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Commands implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;


        if(args.length == 0) {
            Utils.sendHelpMessage(sender);
        }


        else if(args[0].equalsIgnoreCase("list") && p.hasPermission("planetaryitems.list")) {
            Inventory gui = Bukkit.createInventory(p, 27, "Planetary Items");

            ItemStack blankItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta meta = blankItem.getItemMeta();
            assert meta != null;
            meta.setDisplayName("");
            blankItem.setItemMeta(meta);

            for(int x = 0; x < 9; x++) {
                gui.setItem(x, blankItem);
                gui.setItem(x + 18, blankItem);
                if(x == 0 || x == 1 || x == 7 || x == 8) gui.setItem(x + 9, blankItem);
            }

            int y = 11;
            for(PlanetItems item : PlanetItems.values()) {
                gui.setItem(y, item.getItem());
                y++;
            }
            p.openInventory(gui);
            return true;
        }


        else if(args[0].equalsIgnoreCase("give") && p.hasPermission("planetaryitems.give")) {
            if(args.length != 4) {
                sender.sendMessage(ChatColor.YELLOW + "Usage: " + ChatColor.GREEN + "/pitems give <player> <item> <amount>");
            }

            else if(args[1].equals(p.getName()) && Bukkit.getOnlinePlayers().contains(p)) {
                for(PlanetItems items : PlanetItems.values()) {
                    if(args[2].equalsIgnoreCase(items.toString())) {
                        try {
                            if (Integer.parseInt(args[3]) > 0) {
                                WorldItem worldItem = items.getItem();
                                worldItem.setAmount(Integer.parseInt(args[3]));
                                p.getInventory().addItem(worldItem);
                                p.updateInventory();
                                return true;
                            }
                        } catch(NumberFormatException exception) {
                            p.sendMessage(ChatColor.DARK_PURPLE + "PlanetaryItems " + ChatColor.DARK_GREEN + "Please give a number amount!");
                        }
                        break;
                    }
                }
            }
        }


        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        final List<String> results = new ArrayList<>();
        if(args.length == 1) {
            results.add("list");
            if(sender.hasPermission("planetaryitems.give")) results.add("give");
            return StringUtil.copyPartialMatches(args[0], results, new ArrayList<>());
        }
        else if(args.length == 2) {
            if(args[0].equalsIgnoreCase("give")) Bukkit.getOnlinePlayers().forEach(p -> results.add(p.getName()));
            return StringUtil.copyPartialMatches(args[1], results, new ArrayList<>());
        }
        else if(args.length == 3) {
            if(args[0].equalsIgnoreCase("give")) {
                for(PlanetItems item : PlanetItems.values())
                    results.add(item.toString().toLowerCase());
                return StringUtil.copyPartialMatches(args[2], results, new ArrayList<>());
            }
        }
        return results;
    }
}
