package Blackjack;
import java.util.Random;

public class Deck {

    private int[] deck;
    private int[] hand;

    public Deck()
    {
        int[] deck = {11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        this.deck = deck;
        this.deck = shuffle();
        int[] hand = {0,0,0,0,0,0,0,0,0};
        this.hand = hand;
    }

    public String printDeck()
    {
        String temp = "";
        for(int i = 0; i<deck.length; i++)
        {
            temp += "" + this.deck[i] + ",";
        }
        return temp;
    }

    public String printHand(int[] hand)
    {
        String temp = "";
        for(int i = 0; i<this.hand.length; i++)
        {
            if(this.hand[i]!=0)
            {
                temp += "" + this.hand[i] + " ";
            }
        }
        return temp;
    }

    public String printDealerHand(int[] dealerhand)
    {
        String temp = "";
        temp = "" + dealerhand[0] + " ?";
        return temp;
    }

    public int checkHandValue(int[] hand)
    {
        int totalValue = 0;
        for(int i = 0; i<this.hand.length; i++)
        {
            totalValue += this.hand[i];
        }
        return totalValue;
    }
    public boolean checkAce()
    {
        for(int i = 0; i<hand.length;i++)
        {
            if(this.hand[i] == 11)
                return true;
        }
        return false;
    }
    public void changeAce()
    {
        int i = 0; int c = 0;
        while(i<hand.length && c==0)
        {
            if(this.hand[i] == 11)
            {
                this.hand[i] = 1;
                c++;
            }
            i++;
        }
    }
    public int[] shuffle()
    {
        Random randomz = new Random();
        for(int i = 0;i<deck.length; i++)
        {
            int randomPosition = randomz.nextInt(deck.length);
            int temp = deck[i];
            deck[i] = deck[randomPosition];
            deck[randomPosition] = temp;
        }
        return deck;
    }
/*
    public int[] dealHand()
    {
        int[] hand = {0,0,0,0,0,0,0,0,0};
        int[] newDeck = new int[deck.length-2];
        hand[0] = deck[deck.length - 1];
        hand[1] = deck[deck.length - 2];
        for(int i = 0; i<this.deck.length-2; i++)       old dealHand
        {
            newDeck[i] = deck[i];
        }
        this.deck = newDeck;
        this.hand = hand;
        return hand;
    }
    */
    public int[] dealHand()
    {
        int[] hand = {0,0,0,0,0,0,0,0,0};
        int[] newDeck = new int[deck.length-2];
        hand[0] = deck[deck.length - 1];
        hand[1] = deck[deck.length - 2];
        for(int i = 0; i<this.deck.length-2; i++)
        {
            newDeck[i] = deck[i];
        }
        this.deck = newDeck;
        this.hand = hand;
        return hand;
    }
    
    public int[] dealDealerHand()
    {
        int[] hand = {0,0,0,0,0,0,0,0,0};
        int[] newDeck = new int[deck.length-2];
        hand[0] = deck[0];
        hand[1] = deck[1];
        for(int i = 0; i<this.deck.length-2; i++)
        {
            newDeck[i] = deck[i];
        }
        this.deck = newDeck;
        return hand;
    }

    public void dealersTurn(int[] dealersHand)
    {
        this.hand = dealersHand;
    }

    public void drawCard()
    {
        int[] hand = this.hand;
        int[] newDeck = new int[deck.length-1];
        int handLength = 0;
        int i = 0;
        while(i<this.hand.length)
        {
            if(hand[i] != 0)
                handLength += 1;
            i++;
        }
        for(int c = 0; c< this.deck.length-1; c++)
        {
            newDeck[c] = deck[c];
        }
        hand[handLength] = deck[(this.deck.length-1)];
        this.deck = newDeck;
        this.hand = hand;
    }
}