import java.util.Random;
public class Deck 
{
   public final int CARDS_IN_DECK = 52;

   Card [] deck;
   int ct = 0;
   
   public Deck()
   {
      deck = new Card[CARDS_IN_DECK];
   }
   
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
   
   public Card dealCard()
   {
      ct--;
      return deck[ct];
   }
   
   public Card checkCard()
   {
      return deck[ct-1];
   }
   
   public int cardsRemaining()
   {  
      return ct;
   }
   
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
   
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }
   
   public void add(Card oneCard)
   {
      ct++;
      deck[ct] = oneCard;
   }
   
   public void setct(int ct)
   {
      this.ct = ct;
   }
}

