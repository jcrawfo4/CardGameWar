// Purpose: Create a deck of cards, shuffle, draw, and describe the deck
import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] names = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        for (String suit : suits) {
            for (int i = 0; i < names.length; i++) {
                this.cards.add(new Card(names[i], suit, values[i]));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void describe() {
        for (Card card : cards) {
            card.describe();
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = (int) (Math.random() * cards.size());
            //randomIndex is a random number between 0 and cards.size() - 1
            //we are swapping the card at index i with the card at index randomIndex
            Card temp = cards.get(i); //store the card at index i in a temp variable
            cards.set(i, cards.get(randomIndex)); //set the card at index i to the card at index randomIndex
            cards.set(randomIndex, temp);//
        }
        //we need a temp variable to store the card at index i so that we can swap it with the card at index randomIndex
    }
    public Card draw() {
        return cards.removeFirst();
    }
    // how many cards after drawing?
    public int cardsLeft() {
        return cards.size();
    }
}
