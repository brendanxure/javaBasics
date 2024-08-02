// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

import Interfaces.*;

public class MagicSword extends Sword implements Levelled {

    // Attributes:
    private int myLevel = 0;

    // Constructors:
    public MagicSword(String swordName, int baseDamage) {
        super(swordName, baseDamage);
    }

    // Override the method defined in Sword but modified due to Levelled:
    @Override
    public int getDamage() {
        return super.getDamage() + (myLevel * 5);
    }

    // Define the abstract method promised in Levelled:
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
