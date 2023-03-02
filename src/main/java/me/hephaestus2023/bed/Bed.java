package me.hephaestus2023.bed;

import org.bukkit.plugin.java.JavaPlugin;

public final class Bed extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BedListener(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("murder").setExecutor(new KillCmd());
    }
}
