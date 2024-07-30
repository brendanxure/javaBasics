// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

// Package identifies the subfolder of the project in which the enum can be found
package Interfaces;

import AbstractClasses.InventoryItem; // The itemOwner interface will work on InventoryItems

public interface ItemOwner {
    // Any class that implements this interface must define these promised methods:
    void takeOwnership(InventoryItem item);                     // Add yourself as the owner of the item
    InventoryItem relinquishOwnership(InventoryItem item);      // remove yourself as the owner of the item
}


