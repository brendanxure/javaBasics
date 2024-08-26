public class Teacher {
    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    // Constructor
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    // Accessor
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // Mutators
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void receivedSalary(int salary){
        salaryEarned += salary;
        School.updateTotalMoneySpent(salaryEarned);
    }

    @Override
    public String toString() {
        return "The name of this teacher is " + name + " and earned " + salaryEarned;
    }

}
