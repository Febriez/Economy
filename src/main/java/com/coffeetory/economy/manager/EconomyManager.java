package com.coffeetory.economy.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EconomyManager {

    private static EconomyManager instance;

    private final Map<UUID, Long> data;

    private EconomyManager() {
        data = new HashMap<>();
    }

    public long getData(UUID uuid) {
        if (!data.containsKey(uuid)) data.put(uuid, 0L);
        return data.get(uuid);
    }

    public void addData(UUID uuid, long value) {
        data.put(uuid, getData(uuid) + value);
    }

    public void setData(UUID uuid, long value) {
        data.put(uuid, value);
    }

    public void loadData(UUID uuid, long value) {
        setData(uuid, value);
    }

    public Map<UUID, Long> getData() {
        return data;
    }

    public static EconomyManager getInstance() {
        if (instance == null) instance = new EconomyManager();
        return instance;
    }
}
