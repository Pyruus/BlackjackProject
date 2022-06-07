package view;

import dealer.Dealer;
import deck.Deck;
import player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackjackView {
    private JPanel mainPanel;
    private JTextArea dealerCardsTextArea;
    private JTextArea playerCardsTextArea;
    private JButton drawButton;
    private JButton passButton;

    private static BlackjackView form;
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private int chips;
    private int choice = 0;

    public BlackjackView(){
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = 1;
            }
        });

        passButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = 2;
            }
        });
    }


    public static void runGame(BlackjackView form){
        //SETUP
        int stake;
        boolean player_phase = true;
        boolean busted = false;
        form.deck = new Deck();
        form.deck.shuffleDeck();
        form.player = new Player("Player");
        form.dealer = new Dealer("Dealer");
        form.player.drawCard(form.deck);
        form.player.drawCard(form.deck);
        form.dealer.drawCard(form.deck);
        form.dealer.drawCard(form.deck);
        //GAME
        form.dealerCardsTextArea.append("Dealer's cards: \n");
        form.dealerCardsTextArea.append(form.dealer.getCardsPrint());
        form.playerCardsTextArea.append("Player's cards: \n");
        form.playerCardsTextArea.append(form.player.getCardsPrint());
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("BlackJack");
        form = new BlackjackView();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        runGame(form);
    }
}
