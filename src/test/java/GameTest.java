import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Exception.InvalidHandException;

public class GameTest {
    private Deck gameDeck;

    @Before
    public void testSetup() {
        gameDeck = new Deck();
    }

    @Test
    public void testGameSetup() throws InvalidHandException {
        Game game = new Game(gameDeck, 3, 5);
        System.out.println(game.getGameDeck().getDeck().size());
        Assert.assertTrue("Expected remaining Deck size", game.getGameDeck().getDeck().size() == 37);
        Assert.assertTrue("Expected number of hands", game.getGameHands().size() == 3);
        Assert.assertTrue("Expected cards per hand", game.getGameHands().get(0).getCards().size() == 5);
    }

    @Test
    public void testDealCard() throws InvalidHandException {
        Game game = new Game(gameDeck, 4, 4);
        System.out.println(game.getGameDeck().getDeck().size());
        Assert.assertTrue("Expected remaining Deck size", game.getGameDeck().getDeck().size() == 36);
        Assert.assertTrue("Expected number of hands", game.getGameHands().size() == 4);
        Assert.assertTrue("Expected cards per hand", game.getGameHands().get(0).getCards().size() == 4);
        game.dealEveryPlayerACard();
        Assert.assertTrue("Expected remaining Deck size", game.getGameDeck().getDeck().size() == 32);
        Assert.assertTrue("Expected number of hands", game.getGameHands().size() == 4);
        Assert.assertTrue("Expected cards per hand", game.getGameHands().get(0).getCards().size() == 5);

    }

    @Test (expected = InvalidHandException.class)
    public void testInvalidGameSetup() throws InvalidHandException {
        Game game = new Game(gameDeck, 30, 2);
    }

    @Test (expected = InvalidHandException.class)
    public void testMorePlayersThanCards() throws InvalidHandException {
        Game game = new Game(gameDeck, 55);
    }

    @Test
    public void testGameWithPlayers() throws InvalidHandException {
        Game game = new Game(gameDeck, 5);
        Assert.assertTrue("Assert each player has 10 cards",
                game.getGameHands().get(0).getCards().size() == 10);

        game = new Game(gameDeck, 6);
        Assert.assertTrue("Assert each player has 10 cards",
                game.getGameHands().get(0).getCards().size() == 8);
    }

    @Test (expected = InvalidHandException.class)
    public void testGameInvalidPlayerNumber() throws InvalidHandException {
        Game game = new Game(gameDeck, -1);
    }
}
