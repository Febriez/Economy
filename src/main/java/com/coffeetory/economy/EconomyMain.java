package com.coffeetory.economy;

import com.coffeetory.economy.command.AdminCommand;
import com.coffeetory.economy.data.DataManager;
import com.coffeetory.lib.LibraryMain;
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
        DataManager.load();
    }

    @Override
    public void onDisable() {
        try {
            DataManager.save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void registerCommands() {
        LibraryMain.registerCommand(getCommand("돈"), new AdminCommand());
    }

    public static EconomyMain getInstance() {
        return instance;
    }
}
