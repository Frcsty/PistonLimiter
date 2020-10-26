package com.github.frcsty.pistonlimiter.listener;

import com.github.frcsty.pistonlimiter.LimiterPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonRetractEvent;

public final class PistonRetractListener implements Listener {

    @EventHandler
    public void onPistonRetract(final BlockPistonRetractEvent event) {
        LimiterPlugin.handleEvent(event, event.getBlocks());
    }

}
