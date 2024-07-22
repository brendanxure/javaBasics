/*
  Program title:         Enumeration
  Program Author:        Brendan Obilo
                         100952871
  Date:                  22/07/2024

  Description:           An enumeration in a package that stores the names
                         of the Hoodie sizes which contains the chest size and size codes.
 */

package HoodieStyles;

public enum HoodieSize {
    small(36, "S"), medium(40, "M"),
    large(42, "L"), extra_large(46, "XL"),
    extra_small(34, "XS");

    // Attributes
    private int myChestSize;
    private String mySizeCode;

    // Constructor
    HoodieSize(int chestSize, String sizeCode){
        myChestSize = chestSize;
        mySizeCode = sizeCode;
    }

    // Accessors
    public int chestSize(){
        return myChestSize;
    }

    @Override
    public String toString(){
        return mySizeCode;
    }
}
