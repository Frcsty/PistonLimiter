package com.github.frcsty.pistonlimiter.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public final class RedstoneCurrentListener implements Listener {

    @EventHandler
    public void onRedstoneCurrentChange(final BlockRedstoneEvent event) {
        final Block block = event.getBlock();

        if (block.getType() != Material.OBSERVER) return;
        final int current = event.getNewCurrent();

        if (current > 1) {
            event.setNewCurrent(1);
        }
    }

}
