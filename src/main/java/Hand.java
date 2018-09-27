import data.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        for (Card card : cards) {
            joiner.add(card.toString());
        }
        return joiner.toString();
    }

}
