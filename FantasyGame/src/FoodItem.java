// Author: Steve Senter
//         Expanded original by Thom MacDonald
//  Date: 27 July 2024

import AbstractClasses.InventoryItem;
import static AbstractClasses.ItemStatus.*;

public class FoodItem extends InventoryItem {

    // Attributes
    private int myFoodValue;    // the total amount of health that can be gained -  depletes with use.

    // Constructors:
    public FoodItem(String name, int health) {
        myFoodValue = Math.abs(health);
        setName(name);          // inherited from InventoryItem
    }

    // Define the abstract methods promised in InventoryItem:

    @Override
    public void storeItem() {
        // if the food can still restore health...
        if (myFoodValue > 0) {
            // if the food is ready or being used...
            if (myStatus != Stored) {
                // pack the food
                System.out.format("Packing %s.\n", getName());
                myStatus = Stored;
            } else { // otherwise
                // remind that the food is already packed
                System.out.format("%s is packed already.\n", getName());
            }
        } else {
            // remind that the food is depleted.
            System.out.format("No need to pack %s. Nothing left to eat.\n", getName());
        }
    }

    @Override
    public int useItem() {
        boolean healthRestored = false; // whether heath was restored or not

        // if the food is ready or being used...
        if (myStatus != Stored) {
            // if the food is not depleted
            if (myFoodValue > 0) {
                // some health is restored
                healthRestored = true;
                // deplete the food value by 1
                myFoodValue -= 1;
                // report to the user
                System.out.format("Taking a bite of %s. Restoring 1 "
                        + "health point.\n", getName());
                // set the status
                myStatus = Using;
            } else {
                // report that the food is depleted
                System.out.format("No more %s left to eat.\n", getName());
            }
        } else {
            // can't eat a packed food item. report.
            System.out.format("%s is stuck in the pack.\n", getName());

        }
        // return 1 if health was restored, 0 if not.
        return healthRestored ? 1 : 0;
    }

    @Override
    public void readyItem() {
        // if the food item is not depleted...
        if (myFoodValue > 0) {
            // check the status
            switch (myStatus) {
                case Ready:
                    // still ready to eat
                    System.out.format("Still ready to eat %s.\n", getName());
                    break;
                case Stored:
                    // unpack
                    System.out.format("Unpacking %s. Ready to eat.\n", getName());
                    break;
                case Using:
                    // ready to eat more
                    System.out.format("Ready to eat more of %s.\n", getName());
                    break;
            }
        } else {
            // report that the food item is depleted
            System.out.format("No %s left to eat.\n", getName());
        }
        // set the status
        myStatus = Ready;
    }

    @Override
    public String toString() {
        return String.format("%s (%d points)", getName(), myFoodValue);
    }
}

