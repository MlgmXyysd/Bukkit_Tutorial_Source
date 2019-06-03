package org.meowcat.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(Bukkit.getPluginCommand("democmd")).setExecutor(new Command());
        getServer().getConsoleSender().sendMessage("My first bukkit plugin enabled!");
    }

    @Override
    public void onLoad() {
        getServer().getConsoleSender().sendMessage("My first bukkit plugin loaded!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("My first bukkit plugin disabled!");
    }
}
