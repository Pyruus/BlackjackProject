import dealer.Dealer;
import deck.Deck;
import player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class dealerTest {
    Dealer testDealer = new Dealer("Dealer");

    @Test
    public void testInheritance(){
        assertInstanceOf(Player.class, testDealer);
    }

    @Test
    public void testPrint(){
        Deck d = new Deck();
        d.shuffleDeck();
        String expected_hidden = d.getCard(d.getCardAmount() - 1).getCardPrint() + "\n[hidden]";
        int value = d.getCard(d.getCardAmount() - 1).getValue() + d.getCard(d.getCardAmount() - 2).getValue();
        String expected_shown = d.getCard(d.getCardAmount() - 1).getCardPrint() + "\n" + d.getCard(d.getCardAmount() - 2).getCardPrint()  + "\n\nValue: " + value;
        testDealer.drawCard(d);
        testDealer.drawCard(d);
        assertEquals(expected_hidden, testDealer.getCardsPrint());
        testDealer.showCards();
        assertEquals(expected_shown, testDealer.getCardsPrint());
    }
}
