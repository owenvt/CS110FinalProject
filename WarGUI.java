import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game; // the guts
   private JPanel topPanel,gamePanel;  // break up regions
   private JButton [][] buttons;    // grid of buttons
   private JLabel status;  // game status
   private JLabel title;   // static title
   public WarGUI()
   {
      setLayout(new GridLayout(2,1));
      game = new War();
      topPanel = new JPanel();
      topPanel.setBackground(Color.green);
      gamePanel = new JPanel(new GridLayout(3,3));
         
      title = new JLabel("Jackie's Tic Tac Toe Game");
      title.setFont(new Font("HELVETICA",Font.ITALIC,36));
      //title.setForeGround(Color.RED);
      topPanel.add(title);
         
      status = new JLabel("Game in progress");
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      topPanel.add(status);
      

      add(topPanel);
      add(gamePanel);
   }
   // handle button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
      
      }
      // disable all buttons
      public void disableAll()
      {
         for (int r=0;r<3;r++)
         {
            for(int c=0;c<3;c++)
            {
               buttons[r][c].setEnabled(false);
            }
         }
      
      }
   }     
}