import card.Card;
import deck.Deck;
import player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class playerTest {
    Player testPlayer = new Player("Player");

    @Test
    public void testName(){
        assertEquals(testPlayer.getName(), "Player");
        testPlayer.setName("Pyrus");
        assertEquals(testPlayer.getName(), "Pyrus");
    }

    @Test
    public void testHand(){
        Deck d = new Deck();
        d.shuffleDeck();
        int expected = d.getCard(d.getCardAmount() - 1).getValue() + d.getCard(d.getCardAmount() - 2).getValue();
        testPlayer.drawCard(d);
        testPlayer.drawCard(d);
        assertEquals(expected, testPlayer.getValue());
    }

//    @Test
//    public void testPrint(){
//        assureEqual
//    }
}
