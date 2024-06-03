//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PlayingCard myCard = new PlayingCard();
        PlayingCard yourCard = new PlayingCard();
        System.out.printf("My card is %d of %d\n", myCard.GetRank(), myCard.GetSuit());
        System.out.printf("Your card is %d of %d\n", yourCard.GetRank(), yourCard.GetSuit());

    }
}