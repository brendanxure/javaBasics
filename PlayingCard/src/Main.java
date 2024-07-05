//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int MAXIMUM_CARD_VALUE = 21;
        final int BEYOND_CARD_VALUE = 22;
        final int DEALER_CARD_THRESHOLD = 16;
        final int NUMBER_OF_CARDS = 2;
        final int ADD_ONE_CARD = 1;
        try {
            // Greet the user
            System.out.println("Welcome to Blackjack");
            System.out.println("**************************************");

            //Initialize and report dealer hand
            Hand dealerHand = new Hand(NUMBER_OF_CARDS);
            dealerHand.FlipCard(0);
            System.out.println("Dealer: " + dealerHand.ToString());

            //Initialize and report player hand
            Hand playerHand = new Hand(NUMBER_OF_CARDS);
            System.out.println("Player: " + playerHand.ToString());

            // Allow the user to add cards to the player hand until bust
            char draw = 'Y';
            while (playerHand.GetValue() < BEYOND_CARD_VALUE && (draw == 'y' || draw == 'Y')){
                draw = Validation.GetValidCharacter("Do you want another card (y/n)?", "YNyn");
                if (draw == 'y' || draw == 'Y'){
                    playerHand.AddCard(ADD_ONE_CARD);
                    System.out.println("Player: " + playerHand.ToString());
                }
            }

            // Automatically complete the dealer hand
            dealerHand.FlipCard(0);
            while(dealerHand.GetValue() < DEALER_CARD_THRESHOLD) {
                dealerHand.AddCard(ADD_ONE_CARD);
            }
            System.out.println("Dealer: " + dealerHand.ToString());

            // Determine winner
            if (playerHand.GetValue() < BEYOND_CARD_VALUE) {
                if (dealerHand.GetValue() > MAXIMUM_CARD_VALUE || dealerHand.GetValue() < playerHand.GetValue()){
                    System.out.println("Congratulation! Player wins");
                }
                else {
                    System.out.println("Sorry. Dealer wins");
                }
            } else if (dealerHand.GetValue() > MAXIMUM_CARD_VALUE) {
                System.out.println("No winner.");
            }
            else {
                System.out.println("Sorry. Dealer wins");
            }
        }
        catch (Exception ex){
            System.out.println("Sorry - " + ex.getMessage());
        }
    }
}