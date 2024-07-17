import java.util.Comparator;

/**
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 * @see <a
 * href="https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html"
 * Comparator (Java Platform SE 8) </a>
 */
public class SortContactByPhoneNumber implements Comparator<Contact> {

    @Override
    public int compare(Contact contact1, Contact contact2) {
        String string1 = contact1.getPhoneNumber() + contact1.getName();
        String string2 = contact2.getPhoneNumber() + contact2.getName();
        return string1.compareTo(string2);
    }

}