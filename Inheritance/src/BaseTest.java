/**
 * A simple base class. Used to demonstrate that Java uses dynamic function
 * binding for methods, as long as they are not static, final, or private.
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 */
public class BaseTest {

    /**
     * A method that calls another class method.
     */
    public void showValue() {
        System.out.format("%-45s: %3d\n", getClass(), getValue());
    }

    /**
     * A method that gets called from another class method and gets overridden
     * in a subclass.
     *
     * @return a hard-coded value.
     */
    public int getValue() {
        return 88;
    }
}
