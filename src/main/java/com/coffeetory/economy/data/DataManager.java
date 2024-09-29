package com.coffeetory.economy.data;

import com.coffeetory.economy.EconomyMain;
import com.coffeetory.economy.manager.EconomyManager;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DataManager {

    private static DataManager instance;

    private static final EconomyManager ecoManager = EconomyManager.getInstance();

    private final File dataFile;

    private DataManager() {
        dataFile = new File(EconomyMain.getInstance().getDataFolder() + "/data.yml");
    }

    public void save() throws IOException {
        YamlConfiguration config = new YamlConfiguration();
        for (UUID key : ecoManager.getData().keySet())
            config.set(key.toString(), ecoManager.getData().get(key));
        config.save(dataFile);
    }

    public void load() {
        if (!dataFile.exists()) return;
        YamlConfiguration config = YamlConfiguration.loadConfiguration(dataFile);
        for (String key : config.getKeys(false))
            ecoManager.loadData(UUID.fromString(key), config.getLong(key));
    }

    public static DataManager getInstance() {
        if (instance == null) instance = new DataManager();
        return instance;
    }
}
