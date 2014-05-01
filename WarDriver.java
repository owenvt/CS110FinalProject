public class WarDriver
{
   public static void main(String [] args)
   {
      War game = new War();
      while(game.getWinner()==0)
      {
         game.battle();
      }
   }
}