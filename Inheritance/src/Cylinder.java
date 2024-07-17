public class Cylinder extends Circle {

    protected double myHeight; // I could name this depth or width too.

    /**
     * Initializes a Cylinder object.
     * @param radius
     * @param height
     */
    public Cylinder(double radius, double height) {
        super(radius); // initialize the base class instance that is
        // part of this object
        //myRadius = Math.abs(radius);
        //myHeight = Math.abs(height); // initialize the remaining attributes
        setHeight(height);
    }

    /**
     * Sets the height attribute to the parameter.
     * @param height
     */
    public void setHeight(double height) {
        myHeight = Math.abs(height);
    }
    /**
     * Gets the value of the height attribute.
     * @return myHeight
     */
    public double getHeight() {
        return myHeight;
    }

    /**
     * Calculates and returns the surface area of a cylinder. Overrides the
     * circle version of area.
     * @return
     */
    @Override
    public double area(){
        /*  surface area = the area of the circles on the top and bottom of the
            cylinder, plus the area of the walls of the cylinder.
        */
        return (super.area() * 2) + (myHeight * Math.PI * 2 * myRadius);
    }

}
