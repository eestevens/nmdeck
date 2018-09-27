package data;

public class Card {
    private Value value;
    private Suit suit;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return value.toString() + ":" + suit.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Card)) {
            return false;
        }

        Card c = (Card) o;

        return (c.getValue().equals(this.getValue()) && c.getSuit().equals(this.getSuit()));
    }
}

