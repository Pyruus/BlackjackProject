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
    private JButton newGameButton;
    private JTextField chipsTextField;
    private JTextField betTextField;
    private JLabel yourChipsLabel;
    private JLabel yourBetLabel;

    private static BlackjackView form;
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private int chips;
    private int bet;
    private boolean busted;
    private boolean round_running;


    public BlackjackView(){
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(round_running) {
                    player.drawCard(deck);
                    if (player.getValue() > 21) {
                        busted = true;
                        gameResult(form);
                    }
                    dealerCardsTextArea.setText(null);
                    playerCardsTextArea.setText(null);
                    dealerCardsTextArea.append("Dealer's cards:\n");
                    dealerCardsTextArea.append(dealer.getCardsPrint());
                    playerCardsTextArea.append("Player's cards:\n");
                    playerCardsTextArea.append(player.getCardsPrint());
                }
            }
        });

        passButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(round_running) {
                    gameResult(form);}
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!round_running) {
                    initRound(form);
                    if (round_running) {
                        dealerCardsTextArea.setText(null);
                        playerCardsTextArea.setText(null);
                        dealerCardsTextArea.append("Dealer's cards:\n");
                        dealerCardsTextArea.append(dealer.getCardsPrint());
                        playerCardsTextArea.append("Player's cards:\n");
                        playerCardsTextArea.append(player.getCardsPrint());
                    }
                }
            }
        });
    }


    public static void initGame(BlackjackView form) {
        //SETUP
        form.deck = new Deck();
        form.deck.fillDeck();
        form.deck.shuffleDeck();
        form.chips = 100;
        form.chipsTextField.setText("" + form.chips);
    }

    public static void initRound(BlackjackView form){
        form.bet = Integer.parseInt(form.betTextField.getText());
        if (form.bet > 0 && form.bet <= form.chips) {
            form.player = new Player("Player");
            form.dealer = new Dealer("Dealer");
            form.busted = false;
            form.round_running = true;
            form.player.drawCard(form.deck);
            form.player.drawCard(form.deck);
            form.dealer.drawCard(form.deck);
            form.dealer.drawCard(form.deck);
        }
    }

    public static void gameResult(BlackjackView form){
        form.dealer.showCards();
        if(!form.busted) {
            while (form.dealer.getValue() < 17) {
                form.dealer.drawCard(form.deck);
            }

            form.dealerCardsTextArea.setText(null);
            form.playerCardsTextArea.setText(null);
            form.dealerCardsTextArea.append("Dealer's cards:\n");
            form.dealerCardsTextArea.append(form.dealer.getCardsPrint());
            form.playerCardsTextArea.append("Player's cards:\n");
            form.playerCardsTextArea.append(form.player.getCardsPrint());

            if (form.player.getValue() > form.dealer.getValue() || form.dealer.getValue() > 21) {
                JOptionPane.showMessageDialog(null, "You won!");
                form.chips += form.bet;
            } else if (form.player.getValue() == form.dealer.getValue()){
                JOptionPane.showMessageDialog(null, "Draw");
            }
            else{
                JOptionPane.showMessageDialog(null, "You lost.");
                form.chips -= form.bet;
            }
        }
        else{
            form.dealerCardsTextArea.setText(null);
            form.playerCardsTextArea.setText(null);
            form.dealerCardsTextArea.append("Dealer's cards:\n");
            form.dealerCardsTextArea.append(form.dealer.getCardsPrint());
            form.playerCardsTextArea.append("Player's cards:\n");
            form.playerCardsTextArea.append(form.player.getCardsPrint());
            JOptionPane.showMessageDialog(null, "Busted! You lost");
            form.chips -= form.bet;
        }
        form.chipsTextField.setText("" + form.chips);
        form.round_running = false;
        if (form.chips <= 0){
            JOptionPane.showMessageDialog(null, "You've lost all of your chips. Restart the game to start again.");
        }
    }


    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("BlackJack");
        form = new BlackjackView();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        initGame(form);
    }
}
