import card.Card;
import deck.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class deckTest {
    Deck testDeck = new Deck();

    @Test
    public void testAmount(){
        assertEquals(52, testDeck.getCardAmount());
        testDeck.drawCard();
        testDeck.drawCard();
        testDeck.drawCard();
        assertEquals(49, testDeck.getCardAmount());
        testDeck.fillDeck();
        assertEquals(49 + 52, testDeck.getCardAmount());
    }

    @Test
    public void testDraw(){
        assertInstanceOf(Card.class, testDeck.drawCard());
        assertEquals(51, testDeck.getCardAmount());
        for (int i = 0; i < 200; i++){
            testDeck.drawCard();
        }
        assertInstanceOf(Card.class, testDeck.drawCard());
    }
}
