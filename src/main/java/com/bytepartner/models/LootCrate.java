package com.bytepartner.models;

import com.bytepartner.exceptions.NegativeAmountException;
import com.bytepartner.exceptions.NotEnoughCreditsException;

public class LootCrate {
    String type;
    int creditCost;
    LootItem lootItem;

    public LootCrate(String type, int creditCost, LootItem lootItem) {

        //Prøver også at tilføje lidt ekstra tjek, bare fordi.
        if (creditCost < 0) {
            throw new NegativeAmountException("LootCrate creditCost cannot be negative.");
        }
        if (lootItem == null || lootItem.getValue() < 0) {
            throw new NegativeAmountException("LootItem value cannot be negative.");
        }

        this.type = type;
        this.creditCost = creditCost;
        this.lootItem = lootItem;
    }

    public int getCreditCost() {
        return creditCost;
    }
    public void setCreditCost(int creditCost) {
        this.creditCost = creditCost;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void openCrate(Player player) {
        if (player.getCredits() < creditCost) {
            throw new NotEnoughCreditsException("Player does not have enough credits to open this loot crate.");
        }
        player.removeCredits(creditCost);
        System.out.println(player.getName() + " opened a " + type + " loot crate!");
        player.getInventory().add(lootItem);
        System.out.println("Added " + lootItem.getName() + " to " + player.getName() + "'s inventory.");
    }

}
