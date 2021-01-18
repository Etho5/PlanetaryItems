package com.etho5.PlanetaryItems;

import com.etho5.PlanetaryItems.commands.Commands;
import com.etho5.PlanetaryItems.events.ClickInventory;
import com.etho5.PlanetaryItems.events.MineBlock;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        System.out.println("[PlanetaryItems] Setting commands...");
        getCommand("pitems").setExecutor(new Commands());
        getCommand("pitems").setTabCompleter(new Commands());
        System.out.println("[PlanetaryItems] Commands set!");

        System.out.println("[PlanetaryItems] Registering events...");
        Bukkit.getPluginManager().registerEvents(new ClickInventory(), this);
        Bukkit.getPluginManager().registerEvents(new MineBlock(), this);
        System.out.println("[PlanetaryItems] Events registered!");

        System.out.println("[PlanetaryItems] PlanetaryItems has been enabled.");
    }

    public void onDisable() {
        System.out.println("[PlanetaryItems] PlanetaryItems has been disabled.");
    }
}
