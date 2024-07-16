public class CartesianPoint {
    private double x;
    private double y;

    // constructor
    public CartesianPoint (){
        x = 0;
        y = 0;
    }

    public CartesianPoint(double newX, double newY){
        SetXY(newX, newY);
    }

    // Accessor
    public double GetX(){return x;}
    public double GetY(){return y;}
    public String ToString(){
        return "(" + x + "," + y + ")";
    }

    public double GetDistanceTo(CartesianPoint nextPoint){
        double retVal = 0;
        double xDiff = x - nextPoint.GetX();
        double yDiff = y - nextPoint.GetY();
        double sum = (xDiff * xDiff) + (yDiff * yDiff);
        retVal = Math.sqrt(sum);
        return retVal;
    }
    // Mutators
    public void SetX(double newX){
        if(newX < 0){
            throw new IllegalArgumentException("X must be positive!");
        }
        x = newX;
    }

    public void SetY(double newY){
        if (newY < 0){
            throw new IllegalArgumentException("Y must be positive");
        }
        y = newY;
    }

    public void SetXY(double newX, double newY){
        SetX(newX);
        SetY(newY);
    }
}
