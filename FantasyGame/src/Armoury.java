// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

// An armoury is a building that holds weapons.
// It is a specialized collection class based on LinkedList.

import java.util.LinkedList;
import AbstractClasses.*;
import Interfaces.ItemOwner;

public class Armoury extends LinkedList<Weapon> implements ItemOwner {

    // Define abstract methods promised in ItemOwner

    @Override
    public void takeOwnership(InventoryItem item) {
        // Armoury can only own weapons that are not already owned
        if (item.getItemOwner() == null) {
            // Armoury can only own weapons
            if (item instanceof Weapon) {
                this.add((Weapon) item);
                item.setItemOwner(this);
            } else {
                throw new IllegalArgumentException(String.format("This armoury"
                        + " cannot hold %s (%s).", item, item.getClass()));
            }
        } else {
            throw new IllegalArgumentException(item + " is already owned.");
        }

    }

    @Override
    public InventoryItem relinquishOwnership(InventoryItem item) {
        // Armoury can only give up weapons it owns
        if (!(item instanceof Weapon && this.contains((Weapon) item))) {
            throw new IllegalArgumentException(String.format("This armoury does not hold %s", item));
        }
        this.remove((Weapon) item);
        item.setItemOwner(null);
        return item;
    }

}
