/*
  Program title:         Payroll
  Program Author:        Brendan Obilo
                         100952871
  Date:                  18/07/2024

  Description:           A class that accepts validated parameters from the inherited class,
                         and uses the calculate pay day method to return the fixed
                         weekly salary of intern in the company.
 */

import java.time.LocalDate;

// An Intern class to inherit the person class and have access to the name and date of the intern
public class Intern extends Employee{
    private final double INTERN_SALARY = 200.00;

    // constructor to initialize all attributes
    public Intern(String name, LocalDate bDate, String empID){
        super(name, bDate, empID);
    }

    // The abstract method from the employee class that calculates the salary weekly for a year
    public double calculatePayDay(){
        return INTERN_SALARY;
    }
}
