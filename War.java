//CS110
//Owen Marshall
//War class

public class War {

   //decks
   Deck original;
   Deck player1;
   Deck player2;
   Deck player1discard;
   Deck player2discard;
   Deck stakes;
   private Card card1, card2;
   private boolean player1wins = false, player2wins = false;
   
   /**
      The default constructor sets up the game
   **/
   public War()
   {
      //make all the decks
      original = new Deck();
      original.freshDeck();
      original.shuffle();
      player1 = new Deck();
      player2 = new Deck();
      player1discard = new Deck();
      player2discard = new Deck();
      stakes = new Deck();
      
      while(!original.isEmpty())
      {
         player1.add(original.dealCard());
         player2.add(original.dealCard());
      }
      
      player1.shuffle();
      player2.shuffle();   
   }
   
   /**
      The battle method simulates a turn
      @param Deck player1
      @param Deck player2
   **/
   public void battle()
   {
      
      System.out.println("Cards for player 1: " + (player1.cardsRemaining()+player1discard.cardsRemaining()));
      System.out.println("Cards for player 2: " + (player2.cardsRemaining()+player2discard.cardsRemaining()));
         
      if(player1.isEmpty())
      {
         reShuffle(player1, player1discard);
         System.out.println("Reshuffling one");
      }
      if(player2.isEmpty())
      {
         reShuffle(player2, player2discard);
         System.out.println("Reshuffling two");
      }
      
      card1 = player1.checkCard();
      card2 = player2.checkCard();
      
      if(card1 == null || card2 == null)
      {
         System.out.println("null");
         if(card1 == null)
         {
            player1.dealCard();
         }
         if(card2 == null)
         {
            player2.dealCard();
         }
      }    
      else if(player1.checkCard().getRank() > player2.checkCard().getRank())
      {
         player1discard.add(player1.dealCard());
         player1discard.add(player2.dealCard());
         while(!stakes.isEmpty())
         {
            player1discard.add(stakes.dealCard());
         }
      }
      else if(player1.checkCard().getRank() < player2.checkCard().getRank())
      {
         player2discard.add(player1.dealCard());
         player2discard.add(player2.dealCard());
         while(!stakes.isEmpty())
         {
            player2discard.add(stakes.dealCard());
         }
      }
      else
      {
         System.out.println("This means war");
         aWar();
      }
      
      checkForWin();
   }
   
   /**
      The reShuffle method recycles the discard pile
      @param Deck main
      @param Deck discard
   **/
   public void reShuffle(Deck main, Deck discard)
   {
      if(!discard.isEmpty())
      {
         int cards = 0;
         while(!discard.isEmpty())
         {
            main.add(discard.dealCard());
            cards++;
         }
         main.setct(cards);
         main.shuffle();
      }
      else
      {
         checkForWin();
      }
   }
   
   /**
      The aWar method simulates a war
   **/
   public void aWar()
   {
      for(int i=0; i<3; i++)
      {
         if(player1.isEmpty())
         {
            reShuffle(player1, player1discard);
         }
         if(player2.isEmpty())
         {
            reShuffle(player2, player2discard);
         }
            
         stakes.add(player1.dealCard());
         stakes.add(player2.dealCard());
      }
      battle();
   }
   
   /**
      the checkForWin method determines if there is a winner
   **/
   public void checkForWin()
   {
      if(player1.isEmpty() && player1discard.isEmpty())
      {
         System.out.println("Player 2 wins.");
         player2wins = true;
      }
      else if(player2.isEmpty() && player2discard.isEmpty())
      {
         System.out.println("Player 1 wins.");
         player1wins = true;
      }
   }
   
   /**
      The getWinner method returns the winner
   **/
   public int getWinner()
   {
      if(player1wins)
         return 1;
      else if(player2wins)
         return 2;
      else
         return 0;
   }
           
}