// Author: Steve Senter
//         Expanded original by Thom MacDonald 2018
//  Date: 27 July 2024

// Package identifies the subfolder of the project in which the enum can be found
package Interfaces;

public interface Levelled {
    // Attributes:
    final int MAXIMUM_LEVEL = 100;
    // Any class that implements this interface must define these promised methods:
    boolean levelUp();
}
