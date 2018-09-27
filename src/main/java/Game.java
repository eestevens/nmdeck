import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import Exception.InvalidHandException;
import data.Card;

public class Game {
    private Deck gameDeck;
    private List<Hand> gameHands;

    public Game(Deck deck, int players, int startingCards) throws InvalidHandException {
        validate(players);
        gameDeck = new Deck();
        gameHands = new ArrayList<>(players);
        if(validGameDeck(deck.getDeck().size(), players, startingCards)) {
            initializeHands(players);
            for(int i = 0; i < startingCards; i ++) { //simulates actually dealing deck
                dealEveryPlayerACard();
            }
        } else{
            throw new InvalidHandException("Required hand size surpasses deck size");
        }
    }

    public Game(Deck deck, int players) throws InvalidHandException {
        validate(players);
        gameDeck = new Deck();
        gameHands = new ArrayList<>(players);
        int cardsToDeal = deck.getDeck().size() / players;
        if(players < deck.getDeck().size()) {
            initializeHands(players);
            for(int i = 0; i < cardsToDeal; i ++) { //simulates actually dealing deck
                dealEveryPlayerACard();
            }
        } else{
            throw new InvalidHandException("Required hand size surpasses deck size");
        }
    }

    private void initializeHands(int players) {
        for(int i = 0; i < players; i ++) {
            gameHands.add(new Hand());
        }
    }

    public void dealEveryPlayerACard() {
        for(Hand hand : gameHands) {
            hand.addCard(gameDeck.dealCard());
        }
    }

    private void validate(int players) throws InvalidHandException {
        if(players <= 0) {
            throw new InvalidHandException("Number of players must be greater than 0");
        }
    }

    private boolean validGameDeck(int deckSize, int players, int startingCards) {
        return deckSize >= players * startingCards;
    }

    public Deck getGameDeck() {
        return gameDeck;
    }

    public List<Hand> getGameHands() {
        return gameHands;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("\nHand:\n");
        for (Hand hand : gameHands) {
            joiner.add(hand.toString());
        }
        String remainingContent = "\nRemaining Deck : " + gameDeck.getDeck().size() + " Cards";
        return "Hand:\n" + joiner.toString() + remainingContent;
    }
}
