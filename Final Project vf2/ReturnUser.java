import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/********************************************************************
  *  CS230 Final Project 
  *  ReturnUser.java  (GUI Class for PartnerPicker)
  * 
  *  Extends the JFrame object 
  *  Displays the a new frame for returning users
  *
  *  @authors Anah Lewi, Trisha Atluri, & Bryant Wu
  *  @date May 5, 2017
  * 
  * 
  * Modified by Anah Lewi & Trisha Atluri for PartnerPicker Application
  *********************************************************************/

public class ReturnUser extends JFrame {
  JLayeredPane lp; 
  protected static PartnerPicker sorter;
  private CompatibilityScore scores;
  private Student user;
  
  public ReturnUser() {

      super("Partner Picker");
      setResizable(false);
      
      //instantiates variables scores, user, & sorter
      CompatibilityScore scores = DriverGUI.scores;
      user = UsernameEnter.user;
      sorter = new PartnerPicker(scores);
      System.out.println("The order of people are \n");
      Vector<Student> list = sorter.matchResults(user);
      
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      setContentPane(new JLabel(new ImageIcon("updated_list.png")));
      pack();
      
      //used a layeredPane() object in order to display image as background
      lp = getLayeredPane();
      
      ImageIcon imageb = new ImageIcon("exit.png");
      ImageIcon imagec = new ImageIcon("partner-button.png");
      JButton exit = new JButton(imageb);
      JButton middle = new JButton(imagec);
      exit.setBackground(Color.gray);
      exit.setBounds(80, 600, 225, 62);
      middle.setBackground(Color.gray);
      middle.setBounds(350, 600, 225, 62); 
      middle.addActionListener(new ButtonListener()); 
      exit.addActionListener(new DoneButtonListener());
      lp.add(middle, new Integer(3));
      lp.add(exit, new Integer(3));
      
      
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
    
    
    
    
    
    
  /******************************************************************
    * Private Class
    * 
    * ButtonListener (Implements ActionListener Interface)
    * 
    * @param: none
    * Once user clicks "Ive Found a Partner" button they will be removed from the list
    * 
    *****************************************************************/ 
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      setVisible(false);
      System.out.println(user);
      DriverGUI.scores.removeStudent(user);
      new LandingPage().setVisible(true);
    }
  }
    
    /******************************************************************
    * Private Class
    * 
    * DoneButtonListener (Implements ActionListener Interface)
    * 
    * @param: none
    * Once user clicks "Done" button they will be redirected to landing page
    * 
    *****************************************************************/ 
    private class DoneButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        setVisible(false);
        new LandingPage().setVisible(true);
      }
    }
    
      /******************************************************************
    * Driver 
    * 
    * Test Cases
    ******************************************************************/
    public static void main(String[] args) {
//      ReturnUser sl = new ReturnUser();
//      sl.setVisible(true);
      
    }
  }