package com.coffeetory.economy;

import com.coffeetory.economy.command.MainCommand;
import com.coffeetory.economy.data.DataManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class EconomyMain extends JavaPlugin {

    private static EconomyMain instance;

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
        DataManager.getInstance().load();
    }

    @Override
    public void onDisable() {
        try {
            DataManager.getInstance().save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void registerCommands() {
        registerCommand(getCommand("돈"), new MainCommand());
    }

    private void registerCommand(PluginCommand cmd, Object clazz) {
        if (cmd == null) return;
        if (clazz instanceof CommandExecutor) cmd.setExecutor((CommandExecutor) clazz);
        if (clazz instanceof TabCompleter) cmd.setTabCompleter((TabCompleter) clazz);
    }

    public static EconomyMain getInstance() {
        return instance;
    }
}
