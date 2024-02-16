import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private List<Card> hand;

    public Player() {
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int incrementScore(int score) {
        return this.score + 1;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public Card flip (List<Card> hand){
        return hand.removeFirst();
    }


    public void describe() {
        System.out.println(name + " has the following cards: \n");
        List<Card> hand = getHand();
        for(Card card : hand){
            card.describe();
        }
    }

}

