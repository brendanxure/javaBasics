// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

import java.util.ArrayList;
import AbstractClasses.InventoryItem;
import Interfaces.*;

public class Player implements ItemOwner, Levelled {

    // Attributes:
    private final String MY_PLAYER_NAME;
    private int myLevel = 1;
    public ArrayList<InventoryItem> myInventory = new ArrayList<>();

    // Constructors:
    public Player(String name) {
        if (name.length() < 0) {
            throw new IllegalArgumentException("Player name must be at least one character. ");
        }
        MY_PLAYER_NAME = name;
    }

    // Accessors:
    public String getPlayerName() {
        return String.format("%s (Level %d)", MY_PLAYER_NAME, myLevel);
    }

    public void showInventory() {
        if (myInventory.isEmpty()) {
            System.out.format("%s has no inventory to show.", getPlayerName());
        } else {
            int itemNumber = 1;
            System.out.println("Inventory for " + getPlayerName());
            System.out.println("=======================================");
            System.out.println("# : Item Name");
            System.out.println("=======================================");
            for (InventoryItem item : myInventory) {
                System.out.format("%02d: %s\n", itemNumber++, item);
            }
        }
    }

    // Define abstract methods promised in ItemOwner

    @Override
    public void takeOwnership(InventoryItem item) {
        if (item.getItemOwner() == null) {
            item.setItemOwner(this);
            myInventory.add(item);
        } else {
            throw new IllegalArgumentException(item + " is already owned (Player)");
        }
    }

    @Override
    public InventoryItem relinquishOwnership(InventoryItem item) {
        if (myInventory.contains(item)) {
            item.setItemOwner(null);
            myInventory.remove(item);

        } else {
            throw new IllegalArgumentException(String.format("%s does not own %s",
                    MY_PLAYER_NAME, item));
        }
        return item;
    }

    // Define abstract methods promised in Levelled

    @Override
    public boolean levelUp() {
        // will the player level up?
        boolean willLevelUp = (myLevel < Levelled.MAXIMUM_LEVEL);
        if (willLevelUp) {
            // level up the player
            myLevel++;
        }
        // return the result
        return willLevelUp;
    }
}

