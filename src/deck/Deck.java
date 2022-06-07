package deck;

import card.Card;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class Deck {
    private Vector<Card> deck = new Vector<>();
    private int current_amount;

    public int getCardAmount(){
        return current_amount;
    }

    public Card getCard(int i){
        return deck.elementAt(i);
    }

    public Deck(){
        File f = new File("src/cards.txt");

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] arguments = line.split(" ");
                    this.deck.add(new Card(arguments[0], Integer.parseInt(arguments[1]), arguments[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        current_amount = deck.size();
    }

    public void printDeck(){
        for(int i = 0; i < deck.size(); i++){
            deck.elementAt(i).printCard();
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public void fillDeck(){
        File f = new File("src/cards.txt");

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] arguments = line.split(" ");
                    this.deck.add(new Card(arguments[0], Integer.parseInt(arguments[1]), arguments[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        current_amount = deck.size();
    }

    public Card drawCard(){
        if (getCardAmount() == 0){
            fillDeck();
        }
        Card drawn = deck.elementAt(deck.size() - 1);
        deck.remove(deck.size() - 1);
        current_amount = deck.size();
        return drawn;
    }

}
