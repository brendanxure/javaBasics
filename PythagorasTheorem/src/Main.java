// Name: Brendan Obilo
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        double distance;

        try{
            CartesianPoint myPoint = new CartesianPoint(2.0, 3.0);
            CartesianPoint nextPoint = new CartesianPoint(5.0, 7.0);
            distance = myPoint.GetDistanceTo(nextPoint);

            System.out.println("My point is " + myPoint.ToString());
            System.out.println("My next point is " + nextPoint.ToString());
            System.out.println("The distance between them is " + distance);
        }
        catch (IllegalArgumentException ex){
            System.out.println("1- " + ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("99-" + ex.getMessage());
        }
    }
}