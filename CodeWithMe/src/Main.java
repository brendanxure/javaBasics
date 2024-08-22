import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");
        Teacher mercy = new Teacher(1, "Aputs Mercy", 750);
        Teacher naz = new Teacher(2, "Big Nazz", 800);
        Teacher alaks = new Teacher(3, "Alaks Amara", 780);

        // List of teachers
        List<Teacher> listOfTeacher = new ArrayList<>();
        listOfTeacher.add(mercy);
        listOfTeacher.add(naz);
        listOfTeacher.add(alaks);

        Student niinsima = new Student("Niinsima Lynn", 1, 95);
        Student khan = new Student("Khan Malaekah", 2, 80);
        Student ritik = new Student("Ritik Sharma", 3, 100);

        // List of students
        List<Student> studentList = new ArrayList<>();
        studentList.add(niinsima);
        studentList.add(khan);
        studentList.add(ritik);

        School durhamCollege = new School(listOfTeacher, studentList);
        khan.payFees(6000);
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CANADA).format(durhamCollege.getTotalMoneyEarned()));

        niinsima.payFees(5000);
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CANADA).format(durhamCollege.getTotalMoneyEarned()));


        // Teachers being paid salary
        mercy.receivedSalary(mercy.getSalary());
        System.out.println("Durham College has paid " + mercy.getName() + " and has " + durhamCollege.getTotalMoneyEarned());

        alaks.receivedSalary(alaks.getSalary());
        System.out.println("Durham College has paid " + alaks.getName() + " and has " + durhamCollege.getTotalMoneyEarned());

        System.out.println(alaks);
        System.out.println(khan);
    }
}