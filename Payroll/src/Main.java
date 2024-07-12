import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            LocalDate birthDate = LocalDate.of(1942, 10, 10);
            Person brendan = new Person("Brendan Xure Obilo", birthDate);
            System.out.println(brendan.getName() + " is " + brendan.getAge());

            SalariedStaff fred = new SalariedStaff("Fred Williams Bloogs", birthDate, "12345678", 45000);
            System.out.println(fred.getName() + " $" + fred.calculatePayDay());

            HourlyWorker ruby = new HourlyWorker("Ruby Senter Alexandria", birthDate, "98765432", 2.0, 94.0);
            System.out.println(ruby.getName() + " $" + ruby.calculatePayDay());

            ruby.SetHourlyRate(23);
            ruby.SetHourlyWorked(24);
            fred.SetSalary(100000);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());;
        }
        try{
            LocalDate birthDate = LocalDate.of(1942, 10, 10);
            Employee[] myStaff = new Employee[5];
            myStaff[0] = new HourlyWorker("Ruby Senter Alexandria", birthDate, "98765432", 2.0, 94.0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}