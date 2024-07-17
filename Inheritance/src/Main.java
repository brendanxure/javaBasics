import java.util.Collections;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Uncomment the demo methods you wish to run:
//        basicInheritance();
        subTypingDemo();
//        bindingTest();
//        objectSuperClassDemo();
//        collectionDemo();
    }

    /**
     * Demonstrating basic inheritance in Java
     */
    static void basicInheritance() {

        System.out.println("BASIC INHERITANCE");
        System.out.println("=================\n");

        Object myObject = new Object();
        System.out.println(myObject.toString());
        System.out.println(myObject.getClass());
        System.out.println(myObject.hashCode());

        pause();

        // create two Circle objects
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.0);
        // create one Cylinder object
        Cylinder cylinder1 = new Cylinder(2.0, 4.0);

        // Output as initialized:
        System.out.println("  SHAPE     AREA");
        System.out.println("========= =========");
        System.out.format("circle1    %6.2f\n", circle1.area());
        System.out.format("circle2    %6.2f\n", circle2.area());
        System.out.format("cylinder1  %6.2f\n", cylinder1.area());

        System.out.println("");
        pause();

    }

    /**
     * Demonstrating Inclusion Polymorphism in Java.
     */
    static void subTypingDemo() {

        System.out.println("\nSUB-TYPING");
        System.out.println("==========\n");

        // create a Circle object
        Circle circle1 = new Circle();
        // create a Cylinder object
        Cylinder cylinder1 = new Cylinder(2.0, 4.0);

        // Confirm that circle1 is a Circle object
        System.out.println("circle1 is a " + circle1.getClass());

        // assign the Cylinder (subclass object) to the Circle (superclass variable)
        System.out.println("Assigning cylinder1 to circle1...");
        circle1 = cylinder1; // circle1 now refers to the cylinder

        // show the radius.
        System.out.format("\nThe radius of circle1 is now: %.2f\n",
                circle1.getRadius()); // this part would work in C++ too.
        // show the area. In C++, this would call Circle::area(), but in Java it
        // calls Cylinder.area(). This is because in Java, object are reference
        // types.
        System.out.format("The area of circle1 is now: %.2f\n", circle1.area());

        // what type of object is circle1?
        System.out.println("circle1 is actually a " + circle1.getClass());
        pause();
        // Pass a Cylinder object to a Circle parameter
        System.out.println("\nPassing cylinder1 to showArea()...");
        showArea(cylinder1); // again, in C++, this would 'slice' the Cylinder
        // into a circle. In Java, it remains a cylinder.

        System.out.println("");
        pause();
    }

    /**
     * Shows the area of the Circle-based shape. Demonstrates inclusion
     * polymorphism (sub-typing).
     *
     * @see
     * <a href="https://en.wikipedia.org/wiki/Polymorphism_(computer_science)">
     * Polymorphism (computer science)</a>
     * @param shape an object of class Circle, or any subclass of Circle.
     */
    static void showArea(Circle shape) {
        System.out.format("\nIn showArea(), the parameter is a %s\n",
                shape.getClass());
        System.out.format("The area is %.2f\n", shape.area());
    }

    /**
     * Demonstrates that instance methods use dynamic binding in Java.
     */
    static void bindingTest() {

        System.out.println("\nBINDING TEST");
        System.out.println("============\n");

        // create a BaseTest and a DerivedTest object.
        BaseTest baseObj = new BaseTest();
        DerivedTest derivedObj = new DerivedTest();

        // call showValue() from baseObj.
        baseObj.showValue();

        // call showValue() from derivedObj.
        // Which version of getValue() is used?
        derivedObj.showValue();
        /*  In Java, binding of methods is dynamic (also known as late or
            runtime binding), unless the method is private, static, or final.
            Methods that are private, static, or final cannot be overriden, so
            they are bound statically (also known as early binding). This is
            different than in C++, which defaults to static binding (also known
            as early or compile-time binding) unless you designate the method as
            virtual. Java does not have a 'virtual' keyword, but any method that
            can be overriden is technically 'virtual'.
         */
        pause();

    }

    static void objectSuperClassDemo() {

        // Declare objects of class Object
        Object anObject = new Object();
        Object anotherObject = new Object();

        // Demonstrate .getClass()
        System.out.format("\n%s Demo\n", anObject.getClass());
        System.out.println("===========================\n");

        /*  Demstrate .toString and .hashCode(). toString converts the object to
            a string with its class name and its hash code. A hash code is a
            fixed-length numeric value that helps identify the object.
         */
        System.out.println("object1 as a string is " + anObject.toString());
        System.out.format("object1 as a hash is %h\n", anObject.hashCode());
        pause();

        // Demomstrate .equals(). Only returns true if both this object and the
        // parameter object refer to the same object.
        if (anObject.equals(anotherObject)) {
            System.out.format("\n%s equals %s\n", anObject.toString(),
                    anotherObject.toString());
        } else {
            System.out.format("\n%s is not equal to %s\n",
                    anObject.toString(), anotherObject.toString());
        }

        Object anObjectCopy = anObject;
        // Same functionality as above, just written more consisely.
        System.out.format("%s %s %s\n", anObject,
                (anObject.equals(anObjectCopy) ? "equals" : "is not equal to"),
                anObjectCopy);
        pause();

        // Demonstrate that all classes inhert Object
        // declare an object of any other class:
        EveryClass anyObject = new EveryClass();
        //Circle anyObject = new Circle();
        System.out.println("\nanyObject as a string is " + anyObject.toString());
        pause();

        // Demonstrate a class that overrides .equals() and .hashCode()
        OverridingTest testObject1 = new OverridingTest(88);
        OverridingTest testObject2 = new OverridingTest(88); // try 77, 88

        System.out.format("\ntestObject1 as a hash is %h", testObject1.hashCode());
        System.out.format("\ntestObject2 as a hash is %h", testObject2.hashCode());

        System.out.println((testObject1.equals(testObject2) ? "\nEQUAL"
                : "\nNOT EQUAL"));

        System.out.println("");

    }

    /**
     * Demonstrating our custom Collection Class.
     */
    static void collectionDemo() {
        try {

            Contact me = new Contact("Thom", "(905)555-9999");
            ContactList contacts = new ContactList(me);

            // ContactList inherits all the methods of a LinkedList<Contact>
            contacts.add(new Contact("Bob", "(123)555-4567"));
            contacts.add(new Contact("Jill", "(123)555-5555"));
            contacts.add(new Contact("Bill", "(123)555-8899"));
            contacts.add(new Contact("Jen", "(123)555-3344"));
            //contacts.add(new Contact("Sally", "{123}555-2211"));

            System.out.println(contacts);
            pause();

            System.out.println("\nSorting the list by name:");
            Collections.sort(contacts, new SortContactByName());
            System.out.println(contacts);
            pause();

            System.out.println("\nSorting the list by phone number:");
            Collections.sort(contacts, new SortContactByPhoneNumber());
            System.out.println(contacts);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Asks the user to press ENTER to continue.
     */
    static void pause() {
        System.out.print("Please press \'ENTER\' key to continue... ");
        new Scanner(System.in).nextLine();
    }
}
