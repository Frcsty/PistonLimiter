package com.github.frcsty.pistonlimiter.listener;

import com.github.frcsty.pistonlimiter.LimiterPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;

public final class PistonExtendListener implements Listener {

    @EventHandler
    public void onPistonExtend(final BlockPistonExtendEvent event) {
        LimiterPlugin.handleEvent(event, event.getBlocks());
    }

}
