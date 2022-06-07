package player;

import card.Card;
import deck.Deck;

import java.util.Vector;

public class Player {
    protected String name;
    protected Vector<Card> hand = new Vector();
    protected int value = 0;
    protected int cards = 0;
    protected int aces = 0;

    public Player(String name){
        this.name = name;
    }

    public void printCards(){
        for (int i = 0; i < cards; i++){
            hand.elementAt(i).printCard();
        }
    }

    public String getCardsPrint(){
        String res = "";
        for (int i = 0; i < cards; i++){
            res += hand.elementAt(i).getCardPrint() + "\n";
        }
        res += "\nValue: " + getValue();
        return res;
    }

    public void setValue(){
        value = 0;
        for (int i = 0; i < cards; i++){
            value = hand.elementAt(i).getValue() + value;
        }
        if (value > 21 && aces > 0){
            for (int i = 0; i < cards; i++){
                if (hand.elementAt(i).getValue() == 11){
                    hand.elementAt(i).setValue(1);
                    aces--;
                    break;
                }
            }
            setValue();
        }
    }

    public int getValue() {
        return value;
    }

    public void showCards() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void drawCard(Deck deck){
        hand.add(deck.drawCard());
        if (hand.elementAt(cards).getValue() == 11){
            aces += 1;
        }
        cards++;
        setValue();
    }
}
