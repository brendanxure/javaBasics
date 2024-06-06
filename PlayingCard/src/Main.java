//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            PlayingCard myCard = new PlayingCard();
            PlayingCard yourCard = new PlayingCard();
            System.out.printf("My card is %s\n", myCard.ToString());
            System.out.printf("Your card is %s\n", yourCard.ToString());
            myCard.SetRank(8);
            myCard.SetSuit(4);
            System.out.printf("My card is now %s\n", myCard.ToString());
            myCard.FlipCard();
            System.out.printf("My card is now %s\n", myCard.ToString());
            myCard.FlipCard();
            System.out.printf("My card is now %s\n", myCard.ToString());
        }
        catch (Exception ex){
            System.out.println("Sorry - " + ex.getMessage());
        }
    }
}