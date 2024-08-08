// Author:      Brendan Obilo
// Date:        02 August 2024
// Description: ExtendedWorkTicket Class: A class that inherits the workTicket class
// which validates passed in attributes and displays required output about the work ticket.

import java.time.LocalDate;

public class ExtendedWorkTicket extends WorkTicket{
    private boolean myOpen;

    // Constructors
    // To create a default constructor
    public ExtendedWorkTicket(){
        super();
        myOpen = true;
    }

    // To create a parameterized constructor that initialize all the inherited attributes
    // using the parameterized constructor from the base class and the myOpen attribute initialized
    // to the last parameter
    public ExtendedWorkTicket(int iNumber, String sID, LocalDate dDate, String sDesc, boolean sMyOpen){
        super(iNumber, sID, dDate, sDesc);
        myOpen = sMyOpen;
    }

    // To create another parameterized constructor for ExtendedWorkTicket that accepts a WorkTicket object
    // and a boolean as parameters and initializes the object appropriately
    public ExtendedWorkTicket(WorkTicket workTicket, boolean sMyOpenNext){
        super(workTicket.GetTicketNumber(), workTicket.GetClientID(), workTicket.GetTicketDate(), workTicket.GetDescription());
        myOpen = sMyOpenNext;
    }

    // Accessor
    public boolean isOpen(){
        return myOpen;
    }

    // Mutator
    // To overload setWorkTicket() to include one more parameter to set the myOpen attribute
    // by calling the base class version of setWorkTicket() to set all the inherited attributes
    public boolean SetWorkTicket(int iNumber, String sID, LocalDate dDate, String sDesc, boolean wMyOpen){
       boolean retVal = super.SetWorkTicket(iNumber, sID, dDate, sDesc);
       if (retVal){
           myOpen = wMyOpen;
       }
       return retVal;
    }

    // To change the state of a ticket to false
    public void closeTicket(){
        myOpen = false;
    }

    // To change the state of a ticket to true
    public void openTicket(){
        myOpen = true;
    }

    // To override toString() so that it calls the base class version to build a String with
    // the inherited attributes, then appends appropriate result
    @Override
    public String toString(){
        String baseClass = super.toString();
        if(myOpen){
            baseClass = baseClass + " " + "Ticket: OPEN";
        } else {
            baseClass = baseClass + " " + "Ticket: CLOSED";
        }
        return baseClass;
    }

}
