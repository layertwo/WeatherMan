package me.fromgate.weatherman.util;

import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

public class MetricsWrapper {
    private static Metrics metrics;
    private final JavaPlugin plugin;

    public MetricsWrapper(final JavaPlugin plugin, final int pluginId){
        this.plugin = plugin;

        this.metrics = new Metrics(plugin, pluginId);
        this.plugin.getLogger().info("Starting Metrics. Opt-out using the global bStats config.");

    }
}
