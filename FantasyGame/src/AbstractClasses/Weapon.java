// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

// Package identifies the subfolder of the project in which the enum can be found
package AbstractClasses;

public abstract class Weapon extends InventoryItem {

    // Attributes:
    private final int MY_DAMAGE; // Once set, cannot be changed

    // Accessors:
    public Weapon(int damage) {
        MY_DAMAGE = Math.abs(damage);
    }

    public int getDamage() {
        return MY_DAMAGE;
    }

    @Override
    public String toString() {
        return String.format("%s (%d damage)", getName(), getDamage());
    }
}

