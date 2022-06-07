package card;

public class Card {

    protected String suit;
    protected int value;
    protected String name;

    public Card(String suit, int value, String name){
        this.suit = suit;
        this.value = value;
        this.name = name;
    }


    public String getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public String getName(){
        return name;
    }

    public void printCard(){
        System.out.println(getSuit() + " " + getName());
    }

    public String getCardPrint(){
        return getSuit() + " " + getName();
    }

    public void setValue(int val) {
        this.value = val;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setName(String name) {
        this.name = name;
    }





}
