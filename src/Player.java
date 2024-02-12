import java.util.List;

public class Player {
    private String name;
    private int score;

    private List<Card> hand;

    public Player() {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void describe() {
        System.out.println("Player: " + name + ", Score: " + score);
    }

}

