import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 */
public class OverridingTest {

    private final int myValue;
    private final LocalDate myDate = LocalDate.now();

    public OverridingTest(int value) {
        myValue = value;
    }

//    @Override
//    public int hashCode() {
//        int hash = (myValue / 2) + (myDate.getDayOfYear() * 100)
//                + myDate.getYear();
//        return hash;
//    }

    @Override
    public boolean equals(Object other) {
        boolean isEqual = false;

        if (this == other) {
            // this and other are the same object in memory
            isEqual = true;
        } else if (other == null) {
            // other doesn't refer to an object
            isEqual = false;
        } else if (other instanceof OverridingTest
                && this.myValue == ((OverridingTest) other).myValue
                && this.myDate.equals(((OverridingTest) other).myDate)) {

            // The other object is the correct class and the fields contain the
            // same values.
            isEqual = true;
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.myValue;
        hash = 83 * hash + Objects.hashCode(this.myDate);
        return hash;
    }
}
