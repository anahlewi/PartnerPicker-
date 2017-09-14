/*-----------------------------------------------
 * Partner Picker 
 * UsernameEnter.java 
 * CS 230 Final Project
 * Anah Lewi, Bryant Wu, Trisha Atluri
 * 5- 5- 2017
 -------------------------------------------------*/
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
public class UsernameEnter extends JFrame {
  private JLayeredPane lp;
  private TextField uname;
  //protected static Student user;
  public static Student user;
//  private CompatibilityScore scores;
  
  public UsernameEnter() {
    super("Enter your Wellesley Username");
    
//   scores = DriverGUI.scores;
    
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setContentPane(new JLabel(new ImageIcon("username.jpg")));
    pack();
    
    lp = getLayeredPane();
    
    ImageIcon newUser = new ImageIcon("newuser.jpg");
    ImageIcon returnUser = new ImageIcon("returnuser.jpg");
    JButton left = new JButton(newUser);
    JButton right = new JButton(returnUser);
    
    uname = new TextField();
    Font font1 = new Font("MS Gothic", Font.BOLD, 26);
    
    uname.setBounds(175, 350, 300, 40);
    uname.setFont(font1);
    left.setBackground(Color.gray);
    right.setBackground(Color.gray);
    left.setBounds(75, 500, 220, 50);
    right.setBounds(325, 500, 220, 50); 
    left.addActionListener(new ButtonListener()); 
    right.addActionListener(new ButtonListener2()); 
    
    lp.add(left, new Integer(3));
        lp.add(right, new Integer(3));
        lp.add(uname, new Integer(3));
      

    }
  
  public Student getStudent(){
    return user;
  }
     
    private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        setVisible(false);
        user = new Student(uname.getText());
        new DayPicker().setVisible(true);
        
      }
    }
    
    private class ButtonListener2 implements ActionListener{
      public void actionPerformed(ActionEvent event){
        user = new Student(uname.getText());
        System.out.println("This is the username class: " + DriverGUI.scores.getNames() + DriverGUI.scores.isStudent(getStudent()));
        if(DriverGUI.scores.isStudent(getStudent())){
          setVisible(false);
          new ReturnUser().setVisible(true);
        }
        else{
          JOptionPane.showMessageDialog(null, "Can not find " + getStudent().toString());
        }
        
        
      }
    }
    public static void main(String[] args) {
        UsernameEnter sl = new UsernameEnter();
        sl.setVisible(true);
        
    }
}