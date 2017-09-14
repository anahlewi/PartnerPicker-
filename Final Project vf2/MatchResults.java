import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/********************************************************************
  * CS230 Final Project 
  *  MatchResults.java  (GUI Class for PartnerPicker)
  *
  *  Extends the JFrame class from the java swing API
  *
  *  @authors Anah Lewi, Trisha Atluri, & Bryant Wu
  *  @date May 5, 2017
  * 
  * 
  * Modified by Anah Lewi and Trisha Atluri for PartnerPicker Application
  *********************************************************************/
public class MatchResults extends JFrame {
  JLayeredPane lp;
  protected static PartnerPicker sorter;
  private CompatibilityScore scores;
  private Student user;
  
  
   
  /******************************************************************
  * Constructor
  * 
  * @param: none
  * instantiates variables scores, user, and sorter 
  * ***********************************/
  public MatchResults() {
      
      //title 
      super("Partner Picker");
      setResizable(false);
      
      //instantiates variables scores, user, & sorter
      CompatibilityScore scores = DriverGUI.scores;
      user = UsernameEnter.user;
      sorter = new PartnerPicker(scores);
      Vector<Student> list = sorter.matchResults(user);


      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      setContentPane(new JLabel(new ImageIcon("your_matches.png")));
      pack();
      
      //used a layeredPane() object in order to display image as background
      lp = getLayeredPane();
        
        ImageIcon imageb = new ImageIcon("done-button.png");
        JButton middle = new JButton(imageb);
        middle.setBackground(Color.gray);
        middle.setBounds(250, 600, 100, 50); 
        middle.addActionListener(new ButtonListener());
        lp.add(middle, new Integer(3));
        
        
        JLabel[] jlabels = new JLabel[list.size()];
        Color myColor = new Color(145, 15, 113, 180);
        Font font1 = new Font("Helvetica", Font.PLAIN, 15);
        JLabel[] ranks = new JLabel[list.size()];
        
        //loop used to display the names of match reuslts
        for(int i=0; i<list.size(); i++){
          jlabels[i] = new JLabel(list.get(i) + "@wellesley.edu", SwingConstants.CENTER);
          jlabels[i].setBounds(355, (300 + 30*i), 190, 25);
          jlabels[i].setBackground(myColor);
          jlabels[i].setOpaque(true);
          jlabels[i].setForeground(Color.white);
          jlabels[i].setFont(font1);
          lp.add(jlabels[i], new Integer(3));
        }
        
        //loop used to display the rankings of each user within the array, determined by their index value 
        for (int i=0; i<list.size(); i++){
          ranks[i] = new JLabel((Integer.toString(i+1)), SwingConstants.CENTER);
          ranks[i].setBounds(157, (300 + 30*i), 25, 25);
          ranks[i].setBackground(myColor);
          ranks[i].setOpaque(true);
          ranks[i].setForeground(Color.white);
          ranks[i].setFont(font1);
          lp.add(ranks[i], new Integer(3));
        }
  }
          
          
          
          
          
       
    //button listener for the done button that redirects the user to the landing page once finished viewing results
    private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        setVisible(false);
        new LandingPage().setVisible(true);
      }
    }
    
     
      /******************************************************************
    * Driver
    * 
    * Test Cases  
    * ***********************************/
    public static void main(String[] args) {
//        MatchResults sl = new MatchResults();
//        sl.setVisible(true);
        
    }
}