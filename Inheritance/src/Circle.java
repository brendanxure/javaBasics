public class Circle {
    protected double myRadius;

    /**
     * Initializes a Circle object using a default radius of 1.0.
     */
    public Circle() {
        myRadius = 1.0;
    }

    /**
     * Initializes a Circle object.
     * @param radius
     */
    public Circle(double radius) {
        myRadius = Math.abs(radius);
        //setRadius(radius);
    }

    /**
     * Sets the radius attribute to the parameter.
     * @param radius
     */
    public void setRadius(double radius) {
        myRadius = Math.abs(radius);
    }

    /**
     * Gets the radius attribute. Cannot be overridden.
     * @return
     */
    public final double getRadius() {
        return myRadius;
    }

    /**
     * Calculate and returns the area of this circle object.
     * @return area (PI * radius squared)
     */
    public double area(){ // try making this final...
        return Math.PI * myRadius * myRadius;
    }

}
