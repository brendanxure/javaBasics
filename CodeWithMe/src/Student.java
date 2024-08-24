public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    public Student(String name, int id, int grade) {
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Not to alter student name, id

    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * To update the fee
     *
     */
    public void payFees(int fees){
        feesPaid += fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    // Accessor
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public int getRemainingFees(){
        return feesTotal - feesPaid;
    }

    @Override
    public String toString() {
        return "The name of this student is " + name + " and is to pay " + getRemainingFees();
    }
}
