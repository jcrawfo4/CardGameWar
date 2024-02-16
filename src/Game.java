import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    List<Player> listOfPlayers = new ArrayList<>();

    public Game(int numberOfPlayers) {
        listOfPlayers = createPlayerList(numberOfPlayers);
        System.out.println("A game of war has been instantiated with " + numberOfPlayers + " players.");

        Deck gameDeck = new Deck();
    }

    public List<Player> createPlayerList(int numberOfPlayers) {
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i <= numberOfPlayers; i++) {
            Player player = new Player();
            player.setName("Player " + i);
            playerList.add(player);
        }
        return playerList;
    }

    private static  List<List<Card>>  createEmptyHands(int numberOfPlayers) {
        List<List<Card>> listOfLists = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            List<Card> listToAdd = new ArrayList<>();
            listOfLists.add(listToAdd);
        }
        return listOfLists;
    }

    public Map<Player, List<Card>> createGame(Deck gameDeck, List<Player> listOfPlayers) {
        int cardsToDistribute = 5;
        gameDeck.shuffle();
        List<List<Card>> emptyHands = createEmptyHands(listOfPlayers.size());// create X empty hands
        //fill up each hand with 5 cards
        while (emptyHands.get(emptyHands.size() - 1).size() < 5) {
            for(int i = 0; i < listOfPlayers.size(); i++){ // for each player
                emptyHands.get(i).add(gameDeck.draw());    // draw a card from the deck and add it to the player's hand
                //System.out.println("Player " + i + " has " + emptyHands.get(i).size() + " cards.");
            }
        }
        //create a map of players and their hands
        Map<Player, List<Card>> playersAndTheirCards = new HashMap<>();
        for(int i = 0; i < listOfPlayers.size(); i++){
            playersAndTheirCards.put(listOfPlayers.get(i), emptyHands.get(i));
            listOfPlayers.get(i).setHand(emptyHands.get(i));
        }
        printPlayersHand(listOfPlayers);

        return playersAndTheirCards;
    }

    private static void printPlayersHand(List<Player> listOfPlayers) {
        for(Player p: listOfPlayers){
            System.out.println(p.getName() + " has the following cards: ");
            for(Card c: p.getHand()){
                c.describe();
            }
            System.out.println("\n");
        }
    }

    public void describeGame(Map<Player, List<Card>> playersAndTheirCards){
        for (Map.Entry<Player, List<Card>> entry : playersAndTheirCards.entrySet()) {
            System.out.println("Player: " + entry.getKey().getName() + " has the following cards: ");
            for (Card card : entry.getValue()) {
                card.describe();
            }
            System.out.println("  \n");
        }
    }

    Player playOneDeal(List<Player> listOfPlayers){
        Player playerWithBestCard = null;
        int highestCardValue = 0;
        Card bestCard = new Card("", "", 0);
        for (Player p: listOfPlayers){
            int playersCardValue = p.getHand().removeLast().getValue();
            if(playersCardValue > highestCardValue){
                highestCardValue = playersCardValue;
                playerWithBestCard = p;
                bestCard = p.getHand().getFirst();
            }
        }
        bestCard.describe();
        assert playerWithBestCard != null;
        playerWithBestCard.incrementScore(playerWithBestCard.getScore());
        describeRoundWinner(playerWithBestCard);
        return playerWithBestCard;
    }
    public void describeRoundWinner(Player player){
        System.out.println("The winner of this round is: " + player.getName());
        System.out.println(player.getName() + " has " + player.getScore() + " points.");
        System.out.println(player.getHand().size() + "  cards remaining");
    }

}