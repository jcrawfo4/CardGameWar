import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> listOfPlayers = new ArrayList<>();
    private Deck roundDeck;

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


    public void dealCardsOut(Deck roundDeck){
        int cardsToDistribute = 5;
        roundDeck.shuffle();
        for(Player player : listOfPlayers){
            List<Card> playersHand = player.getHand();
            for(int i = 0; i < cardsToDistribute; i++){
                playersHand.add(roundDeck.draw());
        }
        player.setHand(playersHand);
        }
    }

    public void playRound(){
        List<Card> cardsInPlay = new ArrayList<>();
        for(Player player : listOfPlayers){
            Card cardInPlay = player.flip(player.getHand());
            cardsInPlay.add(cardInPlay);
        }
        Player roundWinner = determineRoundWinner(cardsInPlay);
        roundWinner.setScore(roundWinner.incrementScore(roundWinner.getScore()));
        describeRoundWinner(roundWinner);
    }

    public Player determineRoundWinner(List<Card> cardsInPlay){
        Player roundWinner  = listOfPlayers.getFirst(); // set the max value required to win the round
        String bestCardDescription  =  "";
        for(Player player : listOfPlayers){
            if(player.getHand().getFirst().getValue() > roundWinner.getHand().getFirst().getValue()){
                bestCardDescription = player.getHand().getFirst().describe();
                roundWinner = player;
            }
        }
        System.out.println("The best card in play is: " +  bestCardDescription );
        System.out.println(roundWinner.getName() + " has won this round! \n with a card of ");
        return roundWinner;
    }

    public void describeRoundWinner(Player player){
        System.out.println("The winner of this round is: " + player.getName());
        System.out.println(player.getName() + " has " + player.getScore() + " points.");
        System.out.println(player.getHand().size() + "  cards remaining");
    }

}