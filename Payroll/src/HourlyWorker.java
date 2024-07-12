import java.time.LocalDate;

public class HourlyWorker extends Employee{
    double hourlyRate;
    double hoursWorked;

    final double MINIMUM_WAGE = 16.0;
    final double MAXIMUM_HOURS = 48.0;

    public HourlyWorker(String name, LocalDate bDate, String empID, double rate, double hours){
        super(name, bDate, empID);
        SetHourlyRate(rate);
        SetHourlyWorked(hours);
    }

    // Accessors
    public double GetHourlyRate(){return hourlyRate;}
    public double GetHoursWorked(){return hoursWorked;}
    public double calculatePayDay(){
        double retVal = 0.0;
        retVal = (Math.round(hourlyRate * hoursWorked * 100.00))/100.00;
        return retVal;
    };

    // Mutators
    public void SetHourlyRate(double rate){
        rate = Math.abs(rate);
        if (rate < MINIMUM_WAGE){
            hourlyRate = MINIMUM_WAGE;
        } else {
            hourlyRate = rate;
        }
    }

    public void SetHourlyWorked(double hours){
        hours = Math.abs(hours);
        if (hours > MAXIMUM_HOURS){
            hoursWorked = MAXIMUM_HOURS;
        } else {
            hoursWorked = hours;
        }
    }
}
