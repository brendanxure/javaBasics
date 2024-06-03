public class PlayingCard {
    private int rank;
    private int suit;
    public boolean faceUp;

    // Constructors
    PlayingCard(){
        rank = 1;
        suit = 1;
        faceUp = true;
    }

    PlayingCard(int newRank, int newSuit, boolean isFaceUp){
        SetRank(newRank);
        SetSuit(newSuit);
        faceUp = isFaceUp;
    }

    // Accessors
    public int GetRank() {return rank;}
    public int GetSuit() {return suit;}

    // Mutators
    public void SetRank(int newRank){
        if (newRank > 0 && newRank < 14){
            rank = newRank;
        }
        else {
            throw new ArithmeticException("Rank must be between 1 and 13");
        }
    }

    public void SetSuit(int newSuit){
        if(newSuit <1 || newSuit > 4){
            throw new ArithmeticException("Rank must be between 1 and 4");
        }
        suit = newSuit;
    }


}
