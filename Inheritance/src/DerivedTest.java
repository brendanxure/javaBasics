/**
 * A class that inherits another class. Used to demonstrate that Java uses
 * dynamic function binding for methods, as long as they are not static, final,
 * or private.
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 */
public class DerivedTest extends BaseTest {

    /**
     * A method that overrides a method from the base class.
     * @return
     */
    @Override
    public int getValue() {
        //return 99;
        return super.getValue() + 11;
    }

}
