package com.etho5.PlanetaryItems.events;

import com.etho5.PlanetaryItems.objects.WorldItem;
import com.etho5.PlanetaryItems.utils.Utils;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MineBlock implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        World world = e.getBlock().getWorld();
        Block b = e.getBlock();
        WorldItem item = Utils.getPlanetDrop(b, world, 10);

        if(item != null) {
            e.setDropItems(false);
            world.dropItem(b.getLocation(), item);
        }
    }
}