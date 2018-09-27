import java.util.Scanner;
import Exception.InvalidHandException;

public class Console {

    public static void main(String[] args) {
        try {
            Game game;
            if (args.length == 1) {
                int players = parseInput(args[0]);
                game = createGame(players);

            } else if (args.length == 2) {
                int players = parseInput(args[0]);
                int cardsPerPlayer = parseInput(args[1]);
                game = createGame(players, cardsPerPlayer);
            } else {
                game = processInput();
            }
            System.out.println(game.toString());
        }catch(InvalidHandException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Game createGame(int players) throws InvalidHandException{
        Deck deck = new Deck();
        deck.shuffle();
        Game game = new Game(deck, players);
        return game;
    }

    private static Game createGame(int players, int cardsPerPlayer) throws InvalidHandException {
        Deck deck = new Deck();
        deck.shuffle();
        Game game = new Game(deck, players, cardsPerPlayer);
        return game;
    }

    private static Game processInput() throws InvalidHandException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players : ");
        String input = scanner.nextLine();
        int numberOfPlayers = parseInput(input);
        scanner.close();
        return createGame(numberOfPlayers);

    }

    private static int parseInput(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch(NumberFormatException e) {
            System.out.println("Invalid Input Found");
        }
        return -1;
    }
}
