public class PlayingCard {
    private int rank;
    private int suit;
    public boolean faceUp;

    static private String[] rankNames = {"FaceDown", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    static private String[] rankChars = {"", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static private String[] suiteNames = {"FaceDown", "Hearts", "Clubs", "Diamonds", "Spades"};
    static private String[] suitChars = {"", "H", "C", "D", "S"};
    static private String[] suitSymbols = {"", "♥", "♦", "♣", "♠"};
    static private int[] cardvalue = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
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

    public  int GetValue(){
        int retVal = 0;
        if (faceUp){
            retVal = cardvalue[rank];
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
    public String GetSuitChar(){return suitChars[GetSuit()];}
    public String GetSuitSymbol(){return suitSymbols[GetSuit()];}
    public String GetRankName(){
        return  rankNames[GetRank()];
    }
    public  String GetRankChar(){return  rankChars[GetRank()];}
    public String ToString() {
        String retVal = "Face Down";
        if (faceUp){
            retVal =  GetRankName() + " of " + GetSuitName();
        }
        return retVal;
    }

    public String ToString(int mode) {
        String retVal = "??";
        if (faceUp){
            switch (mode){
                case 1:
                    retVal =  GetRankChar() + " of " + GetSuitChar();
                    break;
                case 2:
                    retVal =  GetRankChar() + GetSuitSymbol();
                    break;
                default:
                    retVal =  GetRankName() + GetSuitName();
            }
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
