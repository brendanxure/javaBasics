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
        double WEEKS_PER_YEAR = 52.0;
        return (Math.round(salary*100.0/ WEEKS_PER_YEAR))/100.0;
    }

}
