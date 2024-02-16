

public class Card {
    private String name;
    private String suit;
    private int value;

    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    public void describe() {
        //System.out.println("Name: " + name + ", Suit: " + suit + ", Value: " + value);
        System.out.println(name + " of " + suit + ",  Value: " + value);
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

}
