package com.bytepartner.models;

public class LootItem {
    String name;
    String rarity;
    int value;

    public LootItem(String name, String rarity, int value) {
        this.name = name;
        this.rarity = rarity;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public String getRarity() {
        return rarity;
    }
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " (" + rarity + ", value: " + value + ")";
    }
}
