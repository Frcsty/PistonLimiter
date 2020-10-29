package com.github.frcsty.pistonlimiter;

import com.github.frcsty.pistonlimiter.listener.PistonExtendListener;
import com.github.frcsty.pistonlimiter.listener.PistonRetractListener;
import com.github.frcsty.pistonlimiter.listener.RedstoneCurrentListener;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class LimiterPlugin extends JavaPlugin {

    private static final Set<Material> BLOCKED_MATERIALS = new HashSet<>(Arrays.asList(
            Material.REDSTONE_BLOCK, Material.OBSERVER
    ));

    public static void handleEvent(final BlockPistonEvent event, final List<Block> blocks) {
        boolean containsBlacklisted = false;
        for (final Block block : blocks) {
            if (!LimiterPlugin.BLOCKED_MATERIALS.contains(block.getType())) {
                continue;
            }

            containsBlacklisted = true;
            break;
        }

        if (!containsBlacklisted) {
            return;
        }

        for (final Block block : blocks) {
            final Material type = block.getType();

            if (type == Material.SLIME_BLOCK || type == Material.HONEY_BLOCK) {
                event.setCancelled(true);
                break;
            }
        }
    }

    @Override
    public void onEnable() {
        registerListeners(
                new PistonExtendListener(),
                new PistonRetractListener(),

                new RedstoneCurrentListener()
        );
    }

    private void registerListeners(final Listener... listeners) {
        final PluginManager manager = getServer().getPluginManager();

        Arrays.stream(listeners).forEach(listener ->
                manager.registerEvents(listener, this)
        );
    }

}
