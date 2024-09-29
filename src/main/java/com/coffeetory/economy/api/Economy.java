package com.coffeetory.economy.api;

import com.coffeetory.economy.manager.EconomyManager;

import java.util.UUID;

public class Economy {

    private static final EconomyManager manager = EconomyManager.getInstance();

    public long getBalance(UUID uuid) {
        return manager.getData(uuid);
    }

    public boolean has(UUID uuid, long value) {
        return getBalance(uuid) >= value;
    }

    public void subtractBalance(UUID uuid, long value) {
        addBalance(uuid, -value);
    }

    public void addBalance(UUID uuid, long value) {
        manager.addData(uuid, value);
    }

}
