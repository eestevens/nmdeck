package data;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void testSuit() {
        Card card = new Card(Suit.CLUB, Value.Ace);
        Assert.assertTrue("data.Card suit is expected : CLUB", card.getSuit().equals(Suit.CLUB));
        Card newCard = new Card(Suit.DIAMOND, Value.KING);
        Assert.assertTrue("data.Card suit expected : Diamond", newCard.getSuit().equals(Suit.DIAMOND));
    }

    @Test
    public void testValue() {
        Card card = new Card(null, Value.Ace);
        Assert.assertTrue("data.Card value is correct : KING", card.getValue().equals(Value.Ace));
        Card newCard = new Card(Suit.DIAMOND, Value.KING);
        Assert.assertTrue("data.Card value is correct : King", newCard.getValue().equals(Value.KING));
    }

    @Test
    public void testToString() {
        Card card = new Card(Suit.HEART, Value.JACK);
        String expectedOutput = "JACK:HEART";
        Assert.assertTrue("Output is correct", expectedOutput.equals(card.toString()));
    }
}
