/**
 * A simple class to represent a contact (name and phone number). Used as part
 * of a demonstration of a collection class.
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 */
public class Contact {

    // Atributes. Of course, a more realistic example would have many more.
    private String myName;
    private String myPhoneNumber;

    /**
     * Constructor (parameterized only). Initializes the attributes to
     * parameters as long as they are not null.
     *
     * @param name
     * @param phoneNumber
     */
    public Contact(String name, String phoneNumber) {
        setContact(name, phoneNumber); // call the setContact method for validation.
    }

    /**
     * Gets the name of the contact.
     *
     * @return value of myName attribute.
     */
    public String getName() {
        return myName;
    }

    /**
     * Sets the name of contact.
     *
     * @param name the string to set the contact name to.
     * @throws IllegalArgumentException if the name is empty or null.

     */
    public final void setName(String name) {
        if (name != null && name.length() > 0) {
            myName = name;
        } else {
            throw new IllegalArgumentException("Contact name must be at least"
                    + " one character long.");
        }
    }

    /**
     * Gets the phone number of the contact.
     *
     * @return value of myPhoneNumber attribute.
     */
    public String getPhoneNumber() {
        return myPhoneNumber;
    }

    /**
     * Sets the phone number for contact.
     *
     * @param phoneNumber the digits we want to set the contact phone number to.
     * @throws IllegalArgumentException if the phone number is not in the 
     * format "(123)456-7890".

     * @see <a href="https://www.javatpoint.com/java-regex">Java Regex</a>
     */
    public final void setPhoneNumber(String phoneNumber) {

        if (phoneNumber.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
            myPhoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Phone number must be in "
                    + "this format: \"(123)456-7890\"");
        }
    }

    /**
     * Sets both the name and the phone number for the contact.
     *
     * @param name
     * @param phoneNumber
     * @throws IllegalArgumentException if the name is empty or the phone number
     * is not in the format "(123)456-7890".
     */
    public final void setContact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    /**
     * Converts the contact to a single formatted string.
     * @return the contact state as a string.
     */
    @Override
    public String toString() {
        return String.format("%-10s: %s", myName, myPhoneNumber);
    }

}
