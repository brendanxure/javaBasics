// Author:      Steve Senter and the entire class of COSC 1200
// Date:        29th July 2024
// Description: WorkTicket - intended to capture data for help ticket systems.


import java.time.LocalDate;

public class WorkTicket {
    // Attributes
    private int iTicketNumber;
    private String sClientID;
    private LocalDate dTicketDate;
    private String sDescription;

    // Constructors:
    public WorkTicket() {
        iTicketNumber = 0;
        sClientID = "Unknown";
        dTicketDate = LocalDate.now();
        sDescription = "Not available";
    }

    // To overload a constructor with required parameters.
    public WorkTicket(int iNumber, String sID, LocalDate dDate, String sDesc) {
        SetTicketNumber(iNumber);
        SetClientID(sID);
        SetTicketDate(dDate);
        SetDescription(sDesc);
    }

    // Accessors:
    public int GetTicketNumber() {return iTicketNumber;}
    public String GetClientID() {return sClientID;}
    public LocalDate GetTicketDate() {return dTicketDate;}
    public String GetDescription() {return sDescription;}

    // To override toString() so that it can display the required outcome containing the ticket details
    @Override
    public String toString() {
        String state = String.format("Ticket Number: %d \n     Client ID: %s \n     Date: %s \n     Description: %s", iTicketNumber, sClientID, dTicketDate.toString(), sDescription);
        return state;
    }

    // Mutators:
    // To validate the ticket number and update the value
    public void SetTicketNumber(int iNumber) {
        if(!isValidTicketNumber(iNumber)) {
            throw new IllegalArgumentException("Ticket Number must be greater than zero!" + iNumber + "is not acceptable");
        }
        iTicketNumber = iNumber;
    }

    // To validate the client ID and update the value
    public void SetClientID(String sID) {
        if(!isValidClientID(sID)) {
            throw new IllegalArgumentException("Client ID cannot be blank" + sID + "this is not acceptable");
        }
        sClientID = sID;
    }

    // To validate the ticket date and update the value
    public void SetTicketDate(LocalDate dDate) {
        if (!isValidTicketDate(dDate)) {
            throw new IllegalArgumentException("Ticket date must be this century");
        }
        dTicketDate = dDate;
    }

    // To validate the description of the ticket and update it
    public void SetDescription (String sDecs) {
        if (!isValidDescription(sDecs)) {
            throw new IllegalArgumentException("Description cannot be blank");
        }
        sDescription = sDecs;
    }

    // To validate the work ticket details and update the values
    public Boolean SetWorkTicket(int iNumber, String sID, LocalDate dDate, String sDesc) {
        boolean bRetVal = true;
        if (!isValidTicketNumber(iNumber) || !isValidClientID(sID) || !isValidTicketDate(dDate) || !isValidDescription(sDesc)) {
            bRetVal = false;
        }
        else {
            iTicketNumber = iNumber;
            sClientID = sID;
            dTicketDate = dDate;
            sDescription = sDesc;
        }
        return bRetVal;
    }

    // Helpers:
    // To validate the ticket number through SetWorkTicket() and update the values
    private Boolean isValidTicketNumber(int iTicketNumber) {
        return (iTicketNumber > 0);
    }
    // To validate the client ID through SetWorkTicket() and update the values
    private Boolean isValidClientID(String sClientID) {
        return (sClientID.length() > 0 && sClientID.matches("[A-Za-z0-9]+"));
    }
    // To validate the ticket date through SetWorkTicket() and update the values
    private Boolean isValidTicketDate(LocalDate dDate) {
        return (dDate.getYear() > 1999 && dDate.getYear() < 2100);
    }
    // To validate the ticket description through SetWorkTicket() and update the values
    private Boolean isValidDescription(String sDesc) {
        return (sDesc.length() > 0);
    }

}


