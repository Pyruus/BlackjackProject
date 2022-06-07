import card.Card;
import deck.Deck;
import game.Game;

import java.util.Scanner;

//This class is responsible for running console version of game. For graphical version run BlackjackView from view package.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "Player";
        Game game = new Game(name);
        boolean running = true;
        while (running) {
            int choice;
            if (game.getChips() <= 0) {
                System.out.println("You've lost all your chips! Try again by starting a new game.\n");
                running = false;
                break;
            }
            System.out.println("\nYour chips amount: " + game.getChips());
            System.out.println("What would you like to do?");
            System.out.println("1 - play round");
            System.out.println("2 - close game");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    game.runGame("Player");
                    break;

                case 2:
                    running = false;
                    break;

                default:
                    System.out.println("Wrong argument");
                    break;
            }
        }
    }

}
