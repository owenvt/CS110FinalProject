//Owen Marshall
//CS110
//War game (no GUI sorry)
import java.util.Scanner;

public class WarDriver
{
   public static void main(String [] args)
   {
   
      Scanner keyboard = new Scanner(System.in);
      int option;
   
      War game = new War();
      
      System.out.print("Play a game? (1 for yes, 2 for no, 3 for autoplay): ");
      option = keyboard.nextInt();
      
      //main game loop
      while(game.getWinner()==0 && option == 1)
      {
         game.battle();
         System.out.println("Cards for player 1: " + game.getPlayer1cardsRemaining());
         System.out.println("Cards for player 2: " + game.getPlayer2cardsRemaining());
         System.out.println("Your card: " + game.getPlayer1card());
         System.out.println("Your opponent's card: " + game.getPlayer2card());
         System.out.print("Play another round? (1 for yes, 2 for no, 3 for autoplay): ");
         option = keyboard.nextInt();
      }
      
      //autoplay
      if(option == 3)
      {
         while(game.getWinner()==0)
         {
            game.battle();
            System.out.println("Cards for player 1: " + game.getPlayer1cardsRemaining());
            System.out.println("Cards for player 2: " + game.getPlayer2cardsRemaining());
            System.out.println("Your card: " + game.getPlayer1card());
            System.out.println("Your opponent's card: " + game.getPlayer2card());
         }
      }
      
      //display winner
      if(game.getWinner() == 1)
      {
         System.out.println("Player 1 wins!");
      }
      else if(game.getWinner() == 2)
      {
         System.out.println("Player 2 wins!");
      }
      else
      {
         System.out.println("There was no winnner.");
      }
   }
}