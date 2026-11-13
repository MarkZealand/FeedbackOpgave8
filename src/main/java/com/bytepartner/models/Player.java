package com.bytepartner.models;

import com.bytepartner.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.List;

public class Player {

    String name;
    int credits;
    List<LootItem> inventory;

    public Player(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void addCredits(int amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot add a negative amount of credits.");
        }
        this.credits += amount;
    }
    public void removeCredits(int amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot remove a negative amount of credits.");
        }
        this.credits -= amount;
    }
    public void showInfo() {
        System.out.println("Player Name: " + name);
        System.out.println("Credits: " + credits);
        System.out.println("Inventory: " + inventory.toString());
    }
    public List<LootItem> getInventory() {
        return inventory;
    }
}
