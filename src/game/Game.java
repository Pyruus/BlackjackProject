package game;

import dealer.Dealer;
import deck.Deck;
import player.Player;

import java.util.Scanner;

//This class works only for console version of the game. It covers main logic of the game.
public class Game {
    protected int chips;
    protected String player_name;

    public Game(String name){
        this.player_name = name;
        this.chips = 100;
    }

    public void runGame(String name){
        Scanner sc = new Scanner(System.in);
        //SETUP
        int stake;
        boolean player_phase = true;
        boolean busted = false;
        Deck deck = new Deck();
        deck.fillDeck();
        deck.shuffleDeck();
        Player player = new Player(name);
        Player dealer = new Dealer("Dealer");
        player.drawCard(deck);
        player.drawCard(deck);
        dealer.drawCard(deck);
        dealer.drawCard(deck);
        //BETTING
        System.out.println("How many chips would you like to bet?");
        stake = Integer.parseInt(sc.nextLine());
        while (stake <= 0 || stake > getChips()){
            System.out.println("Amount has to be higher than 0 and not higher than your current amount!" );
            System.out.println("Your current amount: " + getChips());
            System.out.println("How many chips would you like to bet?");
            stake = Integer.parseInt(sc.nextLine());
        }
        while (stake > getChips()){
            System.out.println("Amount has to be higher than 0! How many chips would you like to bet?");
            stake = Integer.parseInt(sc.nextLine());
        }
        //GAME
        while (player_phase) {
            System.out.println("Dealer's cards: ");
            dealer.printCards();
            System.out.println("\n" + player.getName() + "'s cards: ");
            player.printCards();
            System.out.println("Value: " + player.getValue());
            int choice = 0;
            while (choice == 0) {
                System.out.println("What would you like to do? (1 - draw 2 - pass)");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        player.drawCard(deck);
                        if (player.getValue() > 21) {
                            player_phase = false;
                            busted = true;
                        }
                        break;
                    case 2:
                        player_phase = false;
                        break;

                    default:
                        System.out.println("Wrong argument.");
                        choice = 0;
                        break;
                }
            }
        }
            dealer.showCards();
            if(!busted) {
                while (dealer.getValue() < 17) {
                    dealer.drawCard(deck);
                }

                System.out.println("Dealer's cards: ");
                dealer.printCards();
                System.out.println("Dealer's value: " + dealer.getValue()+"\n");
                System.out.println(player.getName() + "'s cards: ");
                player.printCards();
                System.out.println(player.getName() + "'s value: " + player.getValue());

                if (player.getValue() > dealer.getValue() || dealer.getValue() > 21) {
                    System.out.println("You won!");
                    changeChips(stake);
                } else if (player.getValue() == dealer.getValue()){
                    System.out.println("Draw.");
                }
                else{
                    System.out.println("You lost!");
                    changeChips(-stake);
                }
            }
            else{
                System.out.println("Dealer's cards: ");
                dealer.printCards();
                System.out.println("Dealer's value: " + dealer.getValue() + "\n");
                System.out.println(player.getName() + "'s cards: ");
                player.printCards();
                System.out.println(player.getName() + "'s value: " + player.getValue());
                System.out.println("Busted! You lost.");
                changeChips(-stake);
            }
        }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getChips() {
        return chips;
    }

    public void changeChips(int change){
        chips += change;
    }
}
