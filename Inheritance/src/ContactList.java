import java.util.LinkedList;

/**
 * Making a custom collection class through inheritance.
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 */
public class ContactList extends LinkedList<Contact> {

    // Additional atrribute(s)
    private Contact myOwner; // the contact info for the owner of this list.

    /**
     * Initializes an empty contact list.
     * @param me
     */
    public ContactList(Contact me) {
        setOwner(me);
    }

    /**
     * Sets the owner of this contact list.
     * @throws IllegalArgumentException if the parameter is null.
     * @param me
     */
    public final void setOwner(Contact me) {
        if (me != null) {
            myOwner = me;
        } else {
            throw new IllegalArgumentException("Owner cannot be null.");
        }
    }

    /**
     * Builds and returns a string containing the entire contact list.
     * @return the contact list as a String.
     */
    @Override
    public String toString() {
        // Owner info:
        StringBuilder builder = new StringBuilder("Contact List for ");
        builder.append(myOwner.getName());

        // Column headings:
        builder.append("\n===========================");
        builder.append("\nName      : Phone Number");
        builder.append("\n===========================\n");

        // Loop for each contact
        for (Contact contact : this) {
            builder.append(contact);
            builder.append("\n");
        }

        // Footing, including number of contacts in the list.
        builder.append("===========================\n");
        builder.append(String.format("Number of conacts: %d\n", this.size()));

        return builder.toString();
    }

}
