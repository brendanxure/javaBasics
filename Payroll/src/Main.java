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
            double totalSalary = 0.0;
            myStaff[0] = new SalariedStaff("Ruby Senter Alexandria", birthDate, "98765432", 45000);
            myStaff[1] = new SalariedStaff("Mercy Senter Aputs", birthDate, "98765432", 45000);
            myStaff[2] = new HourlyWorker("Edwinah Niinsima Lynn", birthDate, "98765432", 2.0, 94.0);
            myStaff[3] = new HourlyWorker("Malaekah Senter Kahn", birthDate, "98765432", 2.0, 94.0);
            myStaff[4] = new HourlyWorker("Brendan Xure Obilo", birthDate, "98765432", 2.0, 94.0);
            for (int index = 0; index < 5; index++){
                System.out.println(myStaff[index].getEmployeeID() + " " + myStaff[index].getName() +
                        " $" + myStaff[index].calculatePayDay());
                totalSalary += myStaff[index].calculatePayDay();
            }
            System.out.println("Total amount paid this week: $" + totalSalary);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}