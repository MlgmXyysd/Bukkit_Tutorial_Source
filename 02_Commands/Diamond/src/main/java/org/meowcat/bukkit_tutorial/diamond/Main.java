package org.meowcat.bukkit_tutorial.diamond;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("diamond")).setExecutor(new Command());
        Objects.requireNonNull(getCommand("diamond")).setTabCompleter(new Tab());
    }

}
