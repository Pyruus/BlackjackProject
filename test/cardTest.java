import card.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class cardTest {
    Card testCard = new Card("spades", 4, "4");

    @Test
    public void testPrint(){
        assertEquals("spades 4", testCard.getCardPrint());
    }

    @Test
    public void testSuit(){
        assertEquals("spades", testCard.getSuit());
        testCard.setSuit("diamonds");
        assertEquals("diamonds", testCard.getSuit());
    }

    @Test
    public void testValue(){
        assertEquals(4, testCard.getValue());
        testCard.setValue(10);
        assertEquals(10, testCard.getValue());
    }

    @Test
    public void testName(){
        assertEquals("4", testCard.getName());
        testCard.setName("10");
        assertEquals("10", testCard.getName());
    }
}
