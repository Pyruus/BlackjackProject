package dealer;

import player.Player;

public class Dealer extends Player {
    protected boolean cards_hidden = true;

    public Dealer(String name) {
        super(name);
    }

    @Override
    public void showCards() {
        cards_hidden = false;
    }

    @Override
    public void printCards() {
        if (!cards_hidden){
            for (int i = 0; i < cards; i++){
                hand.elementAt(i).printCard();
            }
        }
        else{
            hand.elementAt(0).printCard();
            System.out.println("[hidden]");
        }
    }

    @Override
    public String getCardsPrint(){
        String res = "";
        if (!cards_hidden) {
            for (int i = 0; i < cards; i++) {
                res += hand.elementAt(i).getCardPrint() + "\n";
            }
            res += "\nValue: " + getValue();
        }
        else{
            res += hand.elementAt(0).getCardPrint() + "\n" + "[hidden]";
        }
        return res;
    }
}
