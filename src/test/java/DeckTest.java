import data.Card;
import data.Suit;
import data.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DeckTest {
    private Deck testDeck;


    @Before
    public void initializeDeck() {
        testDeck = new Deck();
    }

    @Test
    public void testDeckSize() {
        int expectedDeckSize = 52;
        Assert.assertEquals(expectedDeckSize, testDeck.getDeck().size());
    }

    @Test
    public void testValues() {
        int expectedValueCount = 4;
        List<Card> cards = testDeck.getDeck();
        for(Value val : Value.values()) {
            int count = 0;
            for(Card card : cards) {
                if(card.getValue().equals(val)) {
                    count++;
                }
            }
            Assert.assertTrue("4 of each card value are expected", count == expectedValueCount);

        }
    }

    @Test
    public void testSuits() {
        int expectedSuitCount = 13;
        List<Card> cards = testDeck.getDeck();
        for(Suit suit : Suit.values()) {
            int count = 0;
            for(Card card : cards) {
                if(card.getSuit().equals(suit)) {
                    count++;
                }
            }
            Assert.assertTrue("13 of each card suit are expected", count == expectedSuitCount);
        }
    }

    @Test
    public void testUniqueCards() {
        List<Card> cards = testDeck.getDeck();
        for(int i = 0 ; i < cards.size()-1; i ++) {
            for(int j = i + 1; j < cards.size(); j++) {
                Assert.assertTrue("Each card is unique", !cards.get(i).equals(cards.get(j)));
            }
        }
    }

    @Test
    public void testDealCard() {
        List<Card> cards = testDeck.getDeck();
        for(int expectedDeckSize = cards.size(); expectedDeckSize > 0; expectedDeckSize -- ) {
            Assert.assertTrue("Deck is expected size", expectedDeckSize == cards.size());
            Card dealtCard = testDeck.dealCard();
            cards = testDeck.getDeck();
            Assert.assertTrue("data.Card is not in remaining deck", !cards.contains(dealtCard));
        }
    }

    @Test
    public void testShuffle() {
        testDeck.shuffle();

        Deck comparisonDeck = new Deck();
        for(int i = 0; i < 100000; i ++) {
            comparisonDeck.shuffle();
            Assert.assertTrue("Two shuffled decks should (almost) never be identical", !testDeck.equals(comparisonDeck));
        }
        
    }
}
