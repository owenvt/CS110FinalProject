import java.util.Random;
public class Deck 
{
   public final int CARDS_IN_DECK = 52;

   Card [] deck;
   int ct = 0;
   
   /**
      The default constructer makes a blank deck of 52 cards
   **/
   public Deck()
   {
      deck = new Card[CARDS_IN_DECK];
   }
   
   /**
      The freshdeck method makes a standard deck
   **/
   public void freshDeck()
   {
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck[ct]=new Card(r,s);
            ct = ct + 1;
         }
      } 
   }
   
   /**
      The dealCard method removes and returns the top card
   **/
   public Card dealCard()
   {
      try {
         ct--;
         return deck[ct];
      }
      catch(Exception error) {
         return null;
      }
   }
   
   /**
      The checkCard method returns the top card without removing it
   **/
   public Card checkCard()
   {
      try {
         return deck[ct-1];
      }
      catch(Exception error) {
         return null;
      }
   }
   
   /**
      The cardsRemaining method returns the number of cards remaining
   **/
   public int cardsRemaining()
   {  
      return ct;
   }
   
   /**
      The shuffle method randomizes a deck
   **/
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   
   /**
      The isEmpty method returns true if a deck is empty
   **/
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }
   
   /**
      The add method adds a card to the top of a deck
      @param oneCard
   **/
   public void add(Card oneCard)
   {
      deck[ct] = oneCard;
      ct++;
   }
   
   /**
      The setct method sets the count of a deck
      @param ct
   **/
   public void setct(int ct)
   {
      this.ct = ct;
   }
}

