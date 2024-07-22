/*
  Program title:         Enumeration
  Program Author:        Brendan Obilo
                         100952871
  Date:                  22/07/2024

  Description:           A program that will use classes and enum to display
                         the college program and hoodie sizes using appropriate parameter.
 */

import College.CollegeProgram;
import HoodieStyles.HoodieColour;
import HoodieStyles.HoodieSize;

import  static HoodieStyles.HoodieColour.*;
import static HoodieStyles.HoodieSize.*;
import static College.CollegeProgram.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        enumerationsDemo();
        inheritanceDemo();
    }

    static void enumerationsDemo(){
        Hoodie[] inventory = {
                new Hoodie(charcoal, medium),
                new Hoodie(HoodieColour.brown, HoodieSize.large),
                new Hoodie(HoodieColour.green, HoodieSize.extra_large),
                new Hoodie(HoodieColour.grey, HoodieSize.small),
                new Hoodie(HoodieColour.charcoal, HoodieSize.medium)
        };

        // Show the current Inventory
        System.out.println("Here is our current inventory: ");
        for (Hoodie item: inventory){
            System.out.println("\t" + item.toString());
        }

        // Show all the colour options
        System.out.println("\n Custom hoodie colours: ");
        for (HoodieColour option: HoodieColour.values()){
            System.out.println(option + " ");
        }

        // Show all the size options
        System.out.println("\nCustom hoodie sizes: ");
        int index = 0;
        for (; index < HoodieSize.values().length - 1; index++){
            System.out.println(HoodieSize.values()[index].toString() + ", ");
        }
        System.out.println(HoodieSize.values()[index].toString() + ". ");
    }

    static void inheritanceDemo(){
        // Create an array of objects to represent our current inventory
        Hoodie[] inventory = {
                new ProgramHoodie(CollegeProgram.cpgm, charcoal, extra_large),
                new ProgramHoodie(cfnd, green, large),
                new Hoodie(HoodieColour.grey, HoodieSize.small),
                new Hoodie(charcoal, medium),
                new Hoodie(red, extra_small),
                new ProgramHoodie(cpai, red, extra_small) // degree -4 years
        };
        // Show the current Inventory
        System.out.println("Here is our current inventory: ");
        for (Hoodie item: inventory){
            System.out.println("\t" + item.toString());
        }
        // Show all the Program options
        System.out.println("\n Custom Program options: ");
        for (CollegeProgram option: CollegeProgram.values()){
            System.out.println(option + " ");
        }
    }
}