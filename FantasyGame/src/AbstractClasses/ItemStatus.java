// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

// Package identifies the subfolder of the project in which the enum can be found
package AbstractClasses;

// The status of an item can only be one of stored, using or ready
// Stored implies packed or sheathed or in a cupboard or ...
// Ready implies pulled out of storage and in hand ready to be used.
// Using implies currently being used .

public enum ItemStatus {
    Stored, Ready, Using;
}
