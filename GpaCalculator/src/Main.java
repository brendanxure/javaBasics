//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        final int A_PLUS_MAX = 100;
        final int A_PLUS_MIN = 90;
        final int A_MINUS_MIN = 85;
        final int B_MIN = 80;
        final int B_MINUS_MIN = 75;
        final int C_PLUS_MIN = 70;
        final int C_MIN = 65;
        final int D_MIN = 60;
        final int F_MAX = 50;
        final int ZERO = 0;

        Scanner input = new Scanner(System.in);
        if(answer >= A_PLUS_MIN && answer <= A_PLUS_MAX){
            System.out.println("Your current gp is A plus");
        } else if (answer >= A_MINUS_MIN) {
            System.out.println("Your current gp is A");
        } else if (answer >= B_MIN) {
            System.out.println("Your current gp is A-");
        } else if (answer >= B_MINUS_MIN) {
            System.out.println("Your current gp is B+");
        } else if (answer >= C_PLUS_MIN) {
            System.out.println("Your current gp is B");
        }  else if (answer >= C_MIN) {
            System.out.println("Your current gp is B-");
        }  else if (answer >= D_MIN) {
            System.out.println("Your current gp is C");
        }  else if (answer >= F_MAX) {
            System.out.println("Your current gp is D");
        }  else if (answer>= ZERO) {
            System.out.println("Your current gp is F");
        }
    }
}