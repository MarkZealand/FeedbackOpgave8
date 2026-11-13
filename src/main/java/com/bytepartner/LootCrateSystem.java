package com.bytepartner;

import com.bytepartner.exceptions.NegativeAmountException;
import com.bytepartner.exceptions.NotEnoughCreditsException;
import com.bytepartner.exceptions.PlayerNotFoundException;
import com.bytepartner.models.LootCrate;
import com.bytepartner.models.LootItem;
import com.bytepartner.models.Player;

import java.util.ArrayList;
import java.util.List;

public class LootCrateSystem {

    private static List<Player> players = new ArrayList<>();
    private static List<LootCrate> lootCrates = new ArrayList<>();
    
    public static void main(String[] args) {
        
        createPlayers();

        createLootCrates();

        scenarioOne();

        scenarioTwo();

        scenarioThree();

        scenarioFour();

        players.get(0).showInfo();
        players.get(1).showInfo();
    }


    private static void scenarioFour() {
        // 4) Spiller findes ikke
        try {
            Player ghost = findPlayer("Charlie");
            lootCrates.get(0).openCrate(ghost);
            ghost.showInfo();
        } catch (PlayerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NotEnoughCreditsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void scenarioThree() {
        // 3) Negative credits (unchecked – fanges stadig fint her)
        try {
            players.get(0).addCredits(-50);
            players.get(0).showInfo();
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void scenarioTwo() {
        // 2) Spiller uden nok credits
        try {
            lootCrates.get(1).openCrate(players.get(1));
            players.get(1).showInfo();
        } catch (NotEnoughCreditsException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    private static void scenarioOne() {
        // 1) Spiller åbner crate (virker)
        try {
            lootCrates.get(0).openCrate(players.get(0));
            players.get(0).showInfo();
        } catch (NotEnoughCreditsException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    public static void createPlayers(){
        Player alice = new Player("Alice", 100);
        players.add(alice);
        Player bob   = new Player("Bob", 5);
        players.add(bob);
        Player dave  = new Player("Dave", 250);
        players.add(dave);
    }

    public static void createLootCrates() {

        try {
            LootCrate common = new LootCrate("Common", 10, new LootItem("Sword", "Common", 20));
            lootCrates.add(common);
            LootCrate epic   = new LootCrate("Epic", 50, new LootItem("Ring", "Epic", 100));
            lootCrates.add(epic);
            LootCrate legendary = new LootCrate("Legendary", 100, new LootItem("Crown", "Legendary", -50));
            lootCrates.add(legendary);
        } catch (NegativeAmountException e) {
            System.out.println("Error creating loot crates: " + e.getMessage());
        }

    }

    public static Player findPlayer(String name) throws PlayerNotFoundException {
        for (Player p : players) {
            if (p.getName().equals(name)) return p;
        }
        throw new PlayerNotFoundException("No player found with name: " + name);
    }
}