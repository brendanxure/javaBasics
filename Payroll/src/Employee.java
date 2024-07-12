import java.time.LocalDate;

abstract public class Employee extends  Person{
    private String employeeID;
    final int EMPLOYEE_ID_LENGTH = 8;

    public Employee(String name, LocalDate bDate, String empID){
        super(name, bDate);
        if (CheckEmployeeID(empID)){
            employeeID = empID;
        };
    }

    private boolean CheckEmployeeID(String newID){
//        if (newID.matches("[0-9]") && newID.length() == EMPLOYEE_ID_LENGTH) {
//            employeeID = newID;
//        }
//        else {
//            throw new IllegalArgumentException(newID + " is not an 8 digits number");
//        }
        try {
            Double.parseDouble(newID);
        } catch (Exception ex){
            throw new IllegalArgumentException(newID + " is not a number");
        }
            if (newID.contains("._+")){
                throw new IllegalArgumentException(newID + " is not numeric");
            }
            if (newID.length() != EMPLOYEE_ID_LENGTH) {
                throw new IllegalArgumentException(newID + " is not correct length");
            }

        return true;
    }
    public String getEmployeeID(){return employeeID;}
    abstract double calculatePayDay();
}
