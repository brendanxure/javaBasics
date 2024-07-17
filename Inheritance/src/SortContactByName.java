import java.util.Comparator;

/**
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 * @see <a
 * href="https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html"
 * Comparator (Java Platform SE 8) </a>
 */
public class SortContactByName implements Comparator<Contact> {

    @Override
    public int compare(Contact contact1, Contact contact2) {
        return contact1.toString().compareTo(contact2.toString());
    }

}
