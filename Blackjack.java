/*

Written in 2018 for a project as a script. If i were to remake i would much more appropriately impliment objects and a GUI.

*/

package Blackjack;
import java.util.Scanner;

public class Blackjack {
    
    private Deck deck = new Deck();
    private boolean turnOver = false;
    private String save = "";
    
    public Blackjack()
    {
        this.deck = new Deck();
        this.deck.shuffle();
    }

    public void play()
    {
        Scanner in = new Scanner(System.in);
        this.playHand(in);
        in.close();
    }
    private void playHand(Scanner in)
    {
        int[] playerHand = this.deck.dealHand();
        int[] dealerHand = this.deck.dealDealerHand();
        int i = 0;
        while (i<9 && this.turnOver == false)
        {
            if(this.deck.checkHandValue(playerHand) == 21)
            {
                if(this.deck.checkAce() != true)
                {
                    this.turnOver = true;
                    System.out.println("Opps! You went over 21.");
                }
                if(this.deck.checkAce() != false)
                {
                    this.deck.changeAce();
                    this.turnOver = false;
                }
            }
            System.out.println("You have been dealt: " + this.deck.printHand(playerHand) + " ||  Making your card total: " + this.deck.checkHandValue(playerHand));
            System.out.println("Dealer has been dealt: " + this.deck.printDealerHand(dealerHand)); //feature prints out users hand
            System.out.println();
            if(this.turnOver == false)
            {
                System.out.println("(1) Take another card");
                System.out.println("(2) End turn");
                System.out.println();
                System.out.println("What would you like to do next?: ");
                this.save = in.nextLine();
            }
            if (save.equals("1") && this.turnOver == false)
            {
                choice1(playerHand);
            }
            if (save.equals("2") && this.turnOver == false)
            {
                this.turnOver = true;
            }
            if(!save.equals("1") && !save.equals("2"))
            {
                System.out.println("**Unkown move, try again!**");
            }
            int playerHandValue = this.deck.checkHandValue(playerHand);
            String playerHandCards = this.deck.printHand(playerHand);
            if(this.turnOver == true)
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Dealer's turn!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                this.deck.dealersTurn(dealerHand);
                System.out.println();
                System.out.println("Dealer draw: " + this.deck.printHand(dealerHand) + "To start with: " + this.deck.checkHandValue(dealerHand));
                int c = 0;
                System.out.println();
                while(c<10)
                {
                    if(this.deck.checkHandValue(dealerHand)<17)
                    {
                        this.deck.drawCard();
                        if(this.deck.checkHandValue(dealerHand) > 21)
                        {
                            if(this.deck.checkAce() != false)
                            {
                                this.deck.changeAce();
                            }
                        }
                    }
                    c++;
                }
                int dealerHandValue = this.deck.checkHandValue(dealerHand);
                if(dealerHandValue > 21 && playerHandValue >21)
                {
                    System.out.println(" ||| Draw! ||| ");
                }
                if(dealerHandValue > playerHandValue && dealerHandValue <= 21)
                {
                    System.out.println(" ||| Dealer Wins! ||| ");
                }
                if(dealerHandValue > playerHandValue && dealerHandValue > 21 && playerHandValue < 21)
                {
                    System.out.println(" ||| Player Wins! ||| ");
                }
                if(dealerHandValue < playerHandValue && playerHandValue <= 21)
                {
                    System.out.println(" ||| Player Wins! ||| ");
                }
                if(dealerHandValue < playerHandValue && playerHandValue > 21 && dealerHandValue < 21)
                {
                    System.out.println(" ||| Dealer Wins! ||| ");
                }
                if(dealerHandValue == playerHandValue)
                {
                    System.out.println(" ||| Draw! ||| ");
                }
                System.out.println();
                System.out.println("Dealer finished with: " + this.deck.printHand(dealerHand) + "For a total of: " + dealerHandValue);
                System.out.println();
                System.out.println("Player finished with: " + playerHandCards + "For a total of: " + playerHandValue);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
            }
        i++;
        }
    }
    public void choice1(int[] playerHand)
    {
        this.deck.drawCard();
        if(this.deck.checkHandValue(playerHand) > 21)
        {
            if(this.deck.checkAce() != true)
            {
                this.turnOver = true;
                System.out.println("Opps! You went over 21.");
            }
            if(this.deck.checkAce() != false)
            {
                this.deck.changeAce();
                this.turnOver = false;
            }
        }
    }
}
