/*
  Program title:         Enumeration
  Program Author:        Brendan Obilo
                         100952871
  Date:                  22/07/2024

  Description:           A class that inherits the Hoodie class uses appropriate parameters
                         passed to return the program and Hoodie details.
 */

import College.CollegeProgram;
import HoodieStyles.HoodieColour;
import HoodieStyles.HoodieSize;

public class ProgramHoodie extends Hoodie {
    // Attributes
    private CollegeProgram myProgram;

    // Constructors
    public ProgramHoodie(CollegeProgram program, HoodieColour colour, HoodieSize size) {
        super(colour, size);
        myProgram = program;
    }

    // Accessors
    @Override
    public String toString(){
        return String.format("%s %s", myProgram.toString(), super.toString());
    }

}
