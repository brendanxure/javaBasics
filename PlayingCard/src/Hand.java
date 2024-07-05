import java.util.ArrayList;

public class Hand {
    private ArrayList<PlayingCard> cards = new ArrayList<>();

    // constructor
    public Hand(){

    };
    public Hand(PlayingCard[] newCards) {
        for (PlayingCard card : newCards) {
            AddCard(card);
        }
    }

    public Hand(int numCards) {
        for (int i = 0; i < numCards; i++) {
            PlayingCard card = new PlayingCard();
            AddCard(card);
        }
    }

    // Mutators
    public void AddCard(PlayingCard newCard){
        cards.add(newCard);
    }

    public void AddCard(int newCards){
        for(int i=0; i<newCards; i++){
            PlayingCard card = new PlayingCard();
            cards.add(card);
        }
    }

    public void FlipCard(int index){
        if(index > -1 && index < cards.size()){
            cards.get(index).FlipCard();
        }
    }

    public int GetValue(){
        int retVal = 0;
        int aceCount = 0;
        for (PlayingCard card: cards){
            if(card.GetValue() == 1){
                aceCount++;
            }
            retVal += card.GetValue();
        }
        while (retVal < 12 && aceCount > 0) {
            retVal += 10;
            aceCount--;
        }
        return retVal;
    }

    public  String ToString(){
        String retVal = "";
        for (PlayingCard card : cards) {
            retVal += card.ToString(2) + " ";
        }
        retVal += "(" + GetValue() + ")";
        return retVal;
    }
}
