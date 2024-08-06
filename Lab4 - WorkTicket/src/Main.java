// Author:      Brendan Obilo
// Date:        02 August 2024
// Description: A program that deals with collecting details of a work ticket,
//              validates them and displays required output about the work ticket.
//              This program has two class in which the ExtendedWorkTicket class
//              inherits the WorkTicket class.

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Mainline will demonstrate all functionality of the ExtendedWorkTicket class
        // with no interaction from the users. (no data entry from the user's part)
        WorkTicket[] listOfTicket = new WorkTicket[3];
        System.out.println("\nWelcome to the Work Ticket Program");
        System.out.println("\nExample using work ticket class");

        WorkTicket wt = new WorkTicket(1, "A123", LocalDate.now(), "My keyboard is broken");
        System.out.println(wt.toString());
        // To test for the default constructor method
        listOfTicket[0] = new ExtendedWorkTicket();
        // To test for constructor with inherited parameters and one class parameter
        listOfTicket[1] = new ExtendedWorkTicket(2, "BG45",
                LocalDate.now().minusYears(5), "My first ticket", true);
        // To test for constructor that passes an object as a perimeter
        listOfTicket[2] = new ExtendedWorkTicket(wt, false);

        // To bring each object and print their tickets
        System.out.println("\nExamples using all methods in Extended Work Ticket Class");
        for (WorkTicket workTicket : listOfTicket) {
            System.out.println(workTicket.toString());
        }
        // Creating an object to get the ticket states
        System.out.println("\nExample getting the ticket state using getIsOpen");
        ExtendedWorkTicket getIsOpen = new ExtendedWorkTicket();
        boolean ticketState = getIsOpen.isOpen();
        // To print the current states of the ticket
        System.out.println(ticketState);
        // To determine response for the set work ticket using the inherited class method
        System.out.println("\nResponse for the setWorkTicket() in Extended work ticket using the inherited class method");
        boolean toSetWorkTicket = getIsOpen.SetWorkTicket(3, "XY09", LocalDate.now(), "Good tickets", true);
        System.out.println(toSetWorkTicket);
        // To change the state of the ticket from open to close
        System.out.println("\nChange the state of the ticket from open to close");
        getIsOpen.closeTicket();
        System.out.println(getIsOpen.isOpen());
        // To change the state of the ticket from close to open
        System.out.println("\nChange the state of the ticket from close to open");
        getIsOpen.openTicket();
        System.out.println(getIsOpen.isOpen());
    }
}