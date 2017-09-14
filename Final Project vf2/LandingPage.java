/**-----------------------------------------------
 * Partner Picker 
 * LandingPage.java 
 * CS 230 Final Project
 * Anah Lewi, Bryant Wu, Trisha Atluri
 * This class displays the landing page for our project and gives user 
 * some brief information.
 * @author Anah Lewi
 * 5- 5- 2017
 -------------------------------------------------*/
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
public class LandingPage extends JFrame {
  private JLayeredPane lp;
  private JLabel info;
  private JLabel instructions;
  
  /** 
   * This method is a constructor that creates and adds Java Swing components to the 
   * frame.
   */
  
    public LandingPage() {
         
        super("Partner Picker");
        
        //makes sure user cannot resize frame
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //generates image to be used for background
        setContentPane(new JLabel(new ImageIcon("background.png")));
        pack();
        
        //need to use layered pane since we are using image as background 
        lp = getLayeredPane();
        
        //creates JLabel that stores creators information
        info = new JLabel("Made by: Anah Lewi, Bryant Wu, and Trisha Atluri for CS230", SwingConstants.CENTER);
        
        //creating font/color for JLabel - all methods below are used to customize JLabel
        Font font1 = new Font("MS Gothic", Font.PLAIN, 15);
        Color myColor = new Color(145, 15, 113, 180);
        info.setBounds(0, 745, 614, 50);
        info.setBackground(myColor);
        info.setOpaque(true);
        info.setForeground(Color.white);
        info.setFont(font1);
      
        lp.add(info);

        //single JButton on page that takes user to the next frame
        //JButton uses an image rather than text for aesthetic purposes
        ImageIcon imageb = new ImageIcon("button.png");
        JButton middle = new JButton(imageb);
        middle.setBackground(Color.gray);
        middle.setBounds(200, 600, 220, 50); 
        middle.addActionListener(new ButtonListener()); 
       
        lp.add(middle, new Integer(3));
      

    }
    
    /**This private class is the ButtonListener used for the "Click Here" button
      * Takes user to the next frame where they will enter their username
      * @author Anah Lewi
      */
    
    private class ButtonListener implements ActionListener{
      
      /**
       * Method that takes you to the next frame in application
       * @param event This is the action of clicking the button
       */
      public void actionPerformed(ActionEvent event){
        setVisible(false);
        new UsernameEnter().setVisible(true);
      }
    }
//    public static void main(String[] args) {
//        LandingPage sl = new LandingPage();
//        sl.setVisible(true);
//        
//    }
}