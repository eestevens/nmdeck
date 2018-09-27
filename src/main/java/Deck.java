import data.Card;
import data.Suit;
import data.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static final int STANDARD_DECK = 52;
    private List<Card> cardDeck;

    public Deck() {
        cardDeck = new ArrayList<>(STANDARD_DECK);
        int i = 0;
        for (Suit suit : Suit.values()) {
            for(Value value : Value.values()) {
                cardDeck.add(new Card(suit, value));
            }
        }
    }

    public List<Card> getDeck() {
        return cardDeck;
    }

    public void shuffle() {
        Collections.shuffle(cardDeck);
    }

    public Card dealCard() {
        return cardDeck.remove(0);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Deck)) {
            return false;
        }

        Deck d = (Deck) o;

        if(d.getDeck().size() != this.getDeck().size()) {
            return false;
        }
        for(int i = 0; i < this.getDeck().size(); i ++) {
            Card thisCard = this.getDeck().get(i);
            Card thatCard = d.getDeck().get(i);
            if(!thisCard.equals(thatCard)) {
                return false;
            }
        }
        return true;
    }
}
