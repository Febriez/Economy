package com.coffeetory.economy.data;

import com.coffeetory.economy.EconomyMain;
import com.coffeetory.economy.manager.EconomyManager;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DataManager {

    private static final EconomyManager ecoManager = EconomyManager.getInstance();
    private static final File dataFile = new File(EconomyMain.getInstance().getDataFolder() + "/data.yml");

    public static void save() throws IOException {
        YamlConfiguration config = new YamlConfiguration();
        for (UUID key : ecoManager.getData().keySet())
            config.set(key.toString(), ecoManager.getData().get(key));
        config.save(dataFile);
    }

    public static void load() {
        if (!dataFile.exists()) return;
        YamlConfiguration config = YamlConfiguration.loadConfiguration(dataFile);
        for (String key : config.getKeys(false))
            ecoManager.loadData(UUID.fromString(key), config.getLong(key));
    }
}
