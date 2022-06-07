import dealer.Dealer;
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

//    @Test
//    public void testPrint(){
//        assureEqual
//    }
}
