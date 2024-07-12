import java.time.LocalDate;

public class SalariedStaff extends Employee{
    private double salary;

    public SalariedStaff(String name, LocalDate bDate, String empID, double newSalary){
        super(name, bDate, empID);
        SetSalary(newSalary);
    }
    public double GetSalary(){return salary;}
    public void SetSalary(double newSalary) {
        salary = Math.abs(newSalary);
    }

    public double calculatePayDay(){
        double retVal = Math.round((salary*100.0/52.0)/100);
        return retVal;
    }

}
