// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

// Package identifies the subfolder of the project in which the enum can be found
package AbstractClasses;

import Interfaces.ItemOwner;
import static AbstractClasses.ItemStatus.*;

public abstract class InventoryItem {

    // Attributes:
    private String myName = "";
    protected ItemStatus myStatus = Stored;
    private ItemOwner myOwner = null;

    // Accessors:
    public String getName() {
        return myName;
    }

    public ItemOwner getItemOwner() {
        return myOwner;
    }

    // Mutators:
    public final void setName(String name) {
        if (name.length() > 0) {
            myName = name;
        } else {
            throw new IllegalArgumentException("Item name must be at least one character. ");
        }
    }

    public void setItemOwner(ItemOwner owner) {
        if (myOwner == null || owner == null) {
            myOwner = owner;
        } else {
            throw new IllegalArgumentException("Item is already owned.");
        }
    }


    /*
     * Abstract methods: An abstract method is declared but has no definition in
     * this class. These methods have to be defined somewhere; they are defined
     * in the subclasses of InventoryItem. All inventory items can be stored,
     * used, or readied, but how exactly each of those actions work depends on
     * what specific type of item it is.
     */
    public abstract void storeItem();
    public abstract int useItem();
    public abstract void readyItem();

}

