package com.coffeetory.economy.api;

import com.coffeetory.economy.manager.EconomyManager;

import java.util.UUID;

@SuppressWarnings("unused")
public class Economy {

    private static final EconomyManager manager = EconomyManager.getInstance();

    private final UUID uuid;

    public Economy(UUID uuid) {
        this.uuid = uuid;
    }

    public long getBalance() {
        return manager.getData(uuid);
    }

    public boolean has(long value) {
        return getBalance() >= value;
    }

    public void subtractBalance(long value) {
        addBalance(-value);
    }

    public void addBalance(long value) {
        manager.addData(uuid, value);
    }

}
