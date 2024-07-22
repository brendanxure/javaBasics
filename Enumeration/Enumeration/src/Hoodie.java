/*
  Program title:         Enumeration
  Program Author:        Brendan Obilo
                         100952871
  Date:                  22/07/2024

  Description:           A class that uses appropriate parameters
                         passed to return the Hoodie details.
 */

import HoodieStyles.HoodieColour;
import HoodieStyles.HoodieSize;

public class Hoodie {
    // Attributes
    private HoodieColour myColour;
    private HoodieSize mySize;

    // Constructor
    public Hoodie(HoodieColour colour, HoodieSize size){
        myColour = colour;
        mySize = size;
    }

    // Accessor
    @Override
    public String toString() {
        return String.format("Hoodie: %s, %s", myColour, mySize);
    }
}
