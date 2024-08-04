// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

import AbstractClasses.Weapon;
import static AbstractClasses.ItemStatus.*;

public class Sword extends Weapon {

    // Constructors:
    public Sword(String swordName, int damage) {
        super(damage);          // From parent Weapon
        setName(swordName);     // Inherited from InventoryItem
    }

    // Define the abstract methods promised in InventoryItem (inherited from Weapon):
    @Override
    public void storeItem() {
        // if this sword is not already sheathed..
        if (myStatus != Stored) {
            // sheath this sword
            System.out.format("Sheathing %s.\n", getName());
            myStatus = Stored;
        } else {
            // report that the sword is sheathed already
            System.out.format("%s is in its sheath already.\n", getName());
        }
    }

    @Override
    public int useItem() {
        int damage = 0; // the amount of damaged caused
        switch (myStatus) {
            // if the sword is ready or being used...
            case Ready:
            case Using:
                // swing the sword
                System.out.format("Swinging %s wildly about! Causing %d "
                        + "points of damage.\n", getName(), getDamage());
                // set the status
                myStatus = Using;
                // determine the damage
                damage = getDamage();
                break;

            case Stored:
                // remind that the sword is still in it's sheath
                System.out.format("%s is stuck in its sheath.\n", getName());
                break;
        }
        // return the damage caused
        return damage;
    }

    @Override
    public void readyItem() {
        // report the action:
        switch (myStatus) {
            case Ready:
                System.out.format("Still ready to swing %s.\n", getName());
                break;
            case Stored:
                System.out.format("Unsheathing %s. Ready to swing.\n", getName());
                break;
            case Using:
                System.out.format("Ready to swing %s again.\n", getName());
                break;
        }
        // set the status
        myStatus = Ready;
    }
}

