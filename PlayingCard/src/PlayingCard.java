public class PlayingCard {
    private int rank;
    private int suit;
    public boolean faceUp;

    private String[] suiteNames = {"FaceDown", "Hearts", "Clubs", "Diamonds", "Spades"};
    private String[] rankNames = {"FaceDown", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
                            "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    // Constructors
    PlayingCard(){
        rank = 1 + (int) Math.round(Math.random() * 12.0);
        suit = 1 + (int) Math.round(Math.random() * 3.0);
        faceUp = true;
    }

    PlayingCard (int newRank, int newSuit, boolean isFaceUp){
        SetRank(newRank);
        SetSuit(newSuit);
        faceUp = isFaceUp;
    }

    // Accessors
    public int GetRank() {
        int retVal = 0;
        if (faceUp){
            retVal = rank;
        }
        return retVal;
    }
    public int GetSuit() {
        int retVal = 0;
        if (faceUp){
            retVal = suit;
        }

        return retVal;
    }
    public String GetSuitName(){
        return  suiteNames[GetSuit()];
    }
    public String GetRankName(){
        return  rankNames[GetRank()];
    }
    public String ToString() {
        String retVal = "Face Down";
        if (faceUp){
            retVal =  GetRankName() + " of " + GetSuitName();
        }
        return retVal;
    }

    // Mutators
    public void FlipCard() { faceUp = !faceUp; }

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
            throw new ArithmeticException(newSuit + " is invalid. Suit must be between 1 and 4");
        }
        suit = newSuit;
    }


}
