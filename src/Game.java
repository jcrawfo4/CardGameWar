import java.util.*;

public class Game {
    int numberOfPlayers;
    List<Player> players;

    public Game() {
        int numberOfPlayers = this.numberOfPlayers; // create all the players
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

    public Map<Player, List<Card>> createGame(int numberOfPlayers) {
        int cardsToDistribute = 52 / numberOfPlayers;
        Deck gameDeck = new Deck();
        gameDeck.shuffle();
        List<Player> playerList = createPlayerList(numberOfPlayers);
        //create playersAndTheirCards hashmap
        Map<Player, List<Card>> playersAndTheirCards = new HashMap<>();
        // create a hand for every player
        List<List<Card>> listOfLists = createEmptyHands(numberOfPlayers);
        System.out.println("list of Lists.size() " + listOfLists.size());
        // fill up each hand
        System.out.println("no cards dealt yet - gameDeck.getCards().size()" + gameDeck.getCards().size());
        System.out.println("cards to distribute:  " + cardsToDistribute);
        while (cardsToDistribute > 0) {
            dealOnce(gameDeck, listOfLists); // dealOnce deals 1 card to each player
            cardsToDistribute = cardsToDistribute - 1; // decrement by # of players after dealing
        }
        System.out.println("finished while loop - cards in deck: " + gameDeck.getCards().size());
        for(int i = 0; i < listOfLists.size(); i++){
            playersAndTheirCards.put(playerList.get(i), listOfLists.get(i));
        }
        return playersAndTheirCards;
    }

    private static  List<List<Card>>  createEmptyHands(int numberOfPlayers) {
        List<List<Card>> listOfLists = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            List<Card> listToAdd = new ArrayList<>();
            listOfLists.add(listToAdd);
        }
        return listOfLists;
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

    public void dealOnce(Deck deck, List<List<Card>> hands){
        for(int i = 0; i < hands.size(); i++){
            hands.get(i).add(deck.draw());
        }
    }
}