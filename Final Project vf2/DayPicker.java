/**-----------------------------------------------
 * Partner Picker 
 * DayPicker.java 
 * CS 230 Final Project
 * Anah Lewi, Bryant Wu, Trisha Atluri
 * This class displays the days and time buttons for the user so they can select their 
 * availabilities. It connects to the backend methods in order to store the information and add it
 * to the Student object to compare with other users
 * @author Trisha Atluri and Bryant Wu
 * 5- 5- 2017
 -------------------------------------------------*/
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Arrays;

public class DayPicker extends JFrame {
  private JLayeredPane lp;
  private JPanel times, panel;
  private Vector<JLabel> dayTimes;
  private Vector<JButton> timeButtons;
  private Vector<JButton> dayButtons;
  private int[][] tempTimes;
  private Vector<Integer> currentSelect; //lets you know which day you are currently on
  private Vector<Integer> daysSelected; //shows all the days that have times in them
  private Vector<Integer> timesSelected; //shows which times are selected
  //protected static CompatibilityScore scores;
  protected static Student user;
  
  /**
   * This constructor method creates and then adds all of the buttons and JLabels to the 
   * layered pane. It also adds button listeners to all of the day/time JButtons
   */
  public DayPicker() {
    
    super("Partner Picker");
    
    //gets username of student by creating new instance of object and then accessing 
    //one of its instance variables (user)
    UsernameEnter access = new UsernameEnter();
    access.setVisible(false);
    user = access.getStudent();
    System.out.println("The student's name is: " + user.getName());
    //user = new Student("Trisha");
    
    
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setContentPane(new JLabel(new ImageIcon("daypicker.jpg")));
    pack();
    
    dayTimes = new Vector<JLabel>();
    
    //creates JLabels using for loop and vector
    for (int i = 0; i<7; i++){
      dayTimes.add(new JLabel());
    }
    
    
    //vectors instantiated to help with connecting frontend to backend
    currentSelect = new Vector<Integer>();
    daysSelected = new Vector<Integer>();
    timesSelected = new Vector<Integer>();
    tempTimes = new int[28][14];
    
    //fills in currentSelect and daysSelected with 0
    for (int i = 0; i<14; i++){
      currentSelect.add(0);
      daysSelected.add(0);
    }
    
    //sets all times selected to 0
    for (int i = 0; i<24; i++){
      timesSelected.add(0);
    }


    
    //-----------********FOR TIMES**********-----------------------
    panel = new JPanel();
    
    Vector<Image> images = new Vector<Image>(); //stores images
    Vector<Image> newImgs= new Vector<Image>(); //stores scaled images
    Vector<ImageIcon> icons= new Vector<ImageIcon>(); //stores scaled unclicked images
    Vector<ImageIcon> iconsClicked = new Vector<ImageIcon>(); //stores scaled clicked images
    timeButtons = new Vector<JButton>(); //stores all the buttons
    
    //all images used for buttons
    //the following is to create the time buttons - to make sure they change image when selected
    //and then deselected
    Image eight = new ImageIcon( "8.png" ).getImage() ;
    Image eight30 = new ImageIcon( "830.png" ).getImage() ;
    Image nine = new ImageIcon( "9.png" ).getImage() ;
    Image nine30 = new ImageIcon( "930.png" ).getImage() ;
    Image ten = new ImageIcon( "10.png" ).getImage() ;
    Image ten30 = new ImageIcon( "1030.png" ).getImage() ;
    Image eleven = new ImageIcon( "11.png" ).getImage() ;
    Image eleven30 = new ImageIcon( "1130.png" ).getImage() ;
    Image twelve = new ImageIcon( "12.png" ).getImage() ;
    Image twelve30 = new ImageIcon( "1230.png" ).getImage() ;
    Image thirteen = new ImageIcon( "13.png" ).getImage() ;
    Image thirteen30 = new ImageIcon( "1330.png" ).getImage() ;
    Image fourteen = new ImageIcon( "14.png" ).getImage() ;
    Image fourteen30 = new ImageIcon( "1430.png" ).getImage() ;
    Image fifteen = new ImageIcon( "15.png" ).getImage() ;
    Image fifteen30 = new ImageIcon( "1530.png" ).getImage() ;
    Image sixteen = new ImageIcon( "16.png" ).getImage() ;
    Image sixteen30 = new ImageIcon( "1630.png" ).getImage() ;
    Image seventeen = new ImageIcon( "17.png" ).getImage() ;
    Image seventeen30 = new ImageIcon( "1730.png" ).getImage() ;
    Image eighteen = new ImageIcon( "18.png" ).getImage() ;
    Image eighteen30 = new ImageIcon( "1830.png" ).getImage() ;
    Image nineteen = new ImageIcon( "19.png" ).getImage() ;
    Image nineteen30 = new ImageIcon( "1930.png" ).getImage() ;
    
    images.add(eight);
    images.add(eight30);
    images.add(nine);
    images.add(nine30);
    images.add(ten);
    images.add(ten30);
    images.add(eleven);
    images.add(eleven30);
    images.add(twelve);
    images.add(twelve30);
    images.add(thirteen);
    images.add(thirteen30);
    images.add(fourteen);
    images.add(fourteen30);
    images.add(fifteen);
    images.add(fifteen30);
    images.add(sixteen);
    images.add(sixteen30);
    images.add(seventeen);
    images.add(seventeen30);
    images.add(eighteen);
    images.add(eighteen30);
    images.add(nineteen);
    images.add(nineteen30);

    
    Image i8click = new ImageIcon("8-clicked.png").getImage();
    Image i830click = new ImageIcon("830-clicked.png").getImage();
    Image i9click = new ImageIcon("9-clicked.png").getImage();
    Image i930click = new ImageIcon("930-clicked.png").getImage();
    Image i10click = new ImageIcon("10-clicked.png").getImage();
    Image i1030click = new ImageIcon("1030-clicked.png").getImage();
    Image i11click = new ImageIcon("11-clicked.png").getImage();
    Image i1130click = new ImageIcon("1130-clicked.png").getImage();
    Image i12click = new ImageIcon("12-clicked.png").getImage();
    Image i1230click = new ImageIcon("1230-clicked.png").getImage();
    Image i13click = new ImageIcon("13-clicked.png").getImage();
    Image i1330click = new ImageIcon("1330-clicked.png").getImage();
    Image i14click = new ImageIcon("14-clicked.png").getImage();
    Image i1430click = new ImageIcon("1430-clicked.png").getImage();
    Image i15click = new ImageIcon("15-clicked.png").getImage();
    Image i1530click = new ImageIcon("1530-clicked.png").getImage();
    Image i16click = new ImageIcon("16-clicked.png").getImage();
    Image i1630click = new ImageIcon("1630-clicked.png").getImage();
    Image i17click = new ImageIcon("17-clicked.png").getImage();
    Image i1730click = new ImageIcon("1730-clicked.png").getImage();
    Image i18click = new ImageIcon("18-clicked.png").getImage();
    Image i1830click = new ImageIcon("1830-clicked.png").getImage();
    Image i19click = new ImageIcon("19-clicked.png").getImage();
    Image i1930click = new ImageIcon("1930-clicked.png").getImage();
    
    images.add(i8click);
    images.add(i830click);
    images.add(i9click);
    images.add(i930click);
    images.add(i10click);
    images.add(i1030click);
    images.add(i11click);
    images.add(i1130click);
    images.add(i12click);
    images.add(i1230click);
    images.add(i13click);
    images.add(i1330click);
    images.add(i14click);
    images.add(i1430click);
    images.add(i15click);
    images.add(i1530click);
    images.add(i16click);
    images.add(i1630click);
    images.add(i17click);
    images.add(i1730click);
    images.add(i18click);
    images.add(i1830click);
    images.add(i19click);
    images.add(i1930click);
    

    //rescales and stores all the images into newImgs vector
    for (int i = 0; i<images.size(); i++){
      newImgs.add(images.get(i).getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH));
    }
    
    //creates new ImageIcons using the rescaled images from newImgs. This is stored in icons.
    //We separate clicked and unclicked
    
    for (int i = 0; i<images.size()/2; i++){
      icons.add(new ImageIcon(newImgs.get(i)));
    }
    
    for (int i = images.size()/2; i<images.size(); i++){
      iconsClicked.add(new ImageIcon(newImgs.get(i)));
    }
    
    //create new button, set icon, set selectedIcon, set size, add to panel,add action listener store it in buttons vector
    for(int i = 0; i<images.size()/2; i++){
      timeButtons.add(new JButton());
      timeButtons.get(i).setIcon(icons.get(i));
      timeButtons.get(i).setSelectedIcon(iconsClicked.get(i));
      timeButtons.get(i).setPreferredSize(new Dimension(40,40));
      panel.add(timeButtons.get(i));
      timeButtons.get(i).addActionListener(new TimeButtonListener(timeButtons.get(i), i));
    }
    
    
   
    panel.setOpaque(false);
    
    //creating done button
    panel.setBounds(80, 535, 500, 500);
    panel.setVisible(false);
    ImageIcon d2 = new ImageIcon("done-button.png");
    JButton done2 = new JButton(d2);
    done2.setBounds(285, 690, 80, 50);
    done2.setBackground(Color.gray);
    done2.setPreferredSize(new Dimension(80, 40));
    done2.addActionListener(new ButtonListenerDone2(done2));
    panel.add(done2);
    
    //--------------------*****FOR DAY BUTTONS*****----------------------------------
    lp = getLayeredPane();
   
    //arrays to store image file names
    String[] dayImageFiles = { "m.png", "t.png", "w.png", "tr.png", "f.png", "sa.png", "su.png",
      "m-clicked.png", "t-clicked.png", "w-clicked.png", "tr-clicked.png", 
      "f-clicked.png", "sa-clicked.png", "su-clicked.png"};
    
    String[] dayBarFiles = {"timesMon.png","timesTues.png", "timesWed.png","timesThurs.png", "timesFri.png",
      "timesSat.png", "timesSun.png"};
    
    Vector<ImageIcon> dayImageIcons = new Vector<ImageIcon>();
    dayButtons = new Vector<JButton>();
    
    //adds images to imageicons
    for(int i = 0; i<14; i++){
      dayImageIcons.add(new ImageIcon(dayImageFiles[i]));
    }
    
    //formats and creates first week buttons
    for(int i = 0; i<7; i++){
      dayButtons.add(new JButton());
      dayButtons.get(i).setIcon(dayImageIcons.get(i));
      dayButtons.get(i).setSelectedIcon(dayImageIcons.get(i+7));
      dayButtons.get(i).setBackground(Color.gray);
      lp.add(dayButtons.get(i), new Integer(3));
      dayButtons.get(i).addActionListener(new DayButtonListener(dayButtons.get(i), dayBarFiles[i],i,i));
    }
    
    //formats and creates 2nd week buttons, add panels
    for(int i = 7; i<14; i++){
      dayButtons.add(new JButton());
      dayButtons.get(i).setIcon(dayImageIcons.get(i-7));
      dayButtons.get(i).setSelectedIcon(dayImageIcons.get(i));
      dayButtons.get(i).setBackground(Color.gray);
      lp.add(dayButtons.get(i), new Integer(3));
      dayButtons.get(i).addActionListener(new DayButtonListener(dayButtons.get(i), dayBarFiles[i-7],i,i-7));
    }
    
    //sets size of dayButtons
    dayButtons.get(0).setBounds(125, 300, 60, 60); 
    dayButtons.get(1).setBounds(190, 300, 60, 60);
    dayButtons.get(2).setBounds(255, 300, 60, 60); 
    dayButtons.get(3).setBounds(320, 300, 60, 60); 
    dayButtons.get(4).setBounds(385, 300, 60, 60); 
    dayButtons.get(5).setBounds(450, 300, 60, 60); 
    dayButtons.get(6).setBounds(515, 300, 60, 60); 
    
    dayButtons.get(7).setBounds(125, 375, 60, 60); 
    dayButtons.get(8).setBounds(190, 375, 60, 60);
    dayButtons.get(9).setBounds(255, 375, 60, 60); 
    dayButtons.get(10).setBounds(320, 375, 60, 60); 
    dayButtons.get(11).setBounds(385, 375, 60, 60); 
    dayButtons.get(12).setBounds(450, 375, 60, 60); 
    dayButtons.get(13).setBounds(515, 375, 60, 60); 
    
    //creates second done button
    ImageIcon d = new ImageIcon("done-button.png");
    JButton done = new JButton(d);
    done.setBackground(Color.gray);
    done.setBounds(270, 460, 100, 60);
    lp.add(done, new Integer(3) );
    lp.add(panel, new Integer(3));
    
    
    done.addActionListener(new DoneListener());


    
    
  }
  
  /**
   * This method is used to access the information of the user from 
   * other classes
   * @return user This returns the Student object that represents the user
   */

  public Student getStudent(){
    return user;
  }
  
  /*------------***BUTTON LISTENERS***--------------*/
  
  /**
   * This class is the button listener used for all day buttons.
   * @author Trisha Atluri and Bryant Wu
   */
  
  
  private class DayButtonListener implements ActionListener{
    JButton button;
    int count;
    String imgFile;
    int index;
    int smallI;
    
    /**
     * This is the constructor for the DayButtonListener
     * @param b This is the buton that will be using the ActionListener
     * @param img This is the image file that the button uses
     * @i this is the index of the button in the array that it is stored in
     * @smallI this is the index of the button in another array that it is stored in
     */
    
    public DayButtonListener(JButton b, String img, int i, int smallI){
      button = b;
      count = 0;
      imgFile = img;
      index = i;
    }
    
    /**
     * This method changes the image of the button when it is selected
     * Additionally, it uses vectors to store the information that the user inputs
     */
    
    public void actionPerformed(ActionEvent event){
      int numberOfDaysSelected = 0;
      
      //stores information of which days have been selected in vector
      for (int i = 0; i<currentSelect.size(); i++){
        if (currentSelect.get(i) == 1){
          numberOfDaysSelected++;
        }
      }
      
      
      //changes image of button when selected 
      if (count%2==0 && numberOfDaysSelected == 0 ){
        button.setSelected(true);
        ImageIcon times = new ImageIcon(imgFile);
        dayTimes.set(smallI, new JLabel(times));
        dayTimes.get(smallI).setBounds(105, 460, 450, 65);
        lp.add(dayTimes.get(smallI), new Integer(4));
        panel.setVisible(true);
        
        //indicates that a certain day has been selected
        currentSelect.set(index,1);
      }
      
      else {
        //sets button to "unselected" mode
        button.setSelected(false);
        panel.setVisible(false);
        dayTimes.get(smallI).setVisible(false);
        
        //this clears currentSelect to all 0's
        for (int i = 0; i<currentSelect.size(); i++){
          currentSelect.set(i,0);
          }
        
        currentSelect.set(index,0);
      }
      //increases count - when count is odd, button is unselected; when it is even, button
      //is selected
      count ++;
    }
  }
  
  /** 
   * This class is the button listener used on the smaller done button that the user clicks
   * after they're done entering in the times they are available. It gets the information they 
   * inputed and stores it.
   * @author Bryant Wu and Trisha Atluri 
   */
 
  
  private class ButtonListenerDone2 implements ActionListener{
    JButton button;  
    
    /**
     * This method is a constructor that takes in the button you want to use
     * @param b This is the button that will use the button listsener
     */
      
    public ButtonListenerDone2(JButton b){
      button = b;
    }
    
    /**
     * This method runs everytime the button is clicked
     * It stores the data from the user and stores it.
     * @param event 
     */
    
    public void actionPerformed(ActionEvent event){
      
    //resets currentSelected
      for (int i = 0; i<currentSelect.size(); i++){
        currentSelect.set(i, 0);
      }   
      
      //get data and store in vector
      for(int i = 0; i<timeButtons.size(); i++){
        timeButtons.get(i).setSelected(false);
      }
      
      panel.setVisible(false);
      
      for (int i = 0; i<dayTimes.size(); i++){
        dayTimes.get(i).setVisible(false);
      }      
    }
  }
  
  /*---------------*FOR ALL TIME BUTTONS*-------------*/
  
  /** 
   * This class is used for all of the time buttons
   * It changes the image of the button everytime it is selected and also stores the information 
   * elsewhere to be added to the Student object that represents the user
   */
  
  public class TimeButtonListener implements ActionListener{
    JButton button;
    int time; //stores the data that tells you what time you are adjusting in the matrix
    int status;
    
    /**
     * Constructor method 
     * @param b
     * @param t This is what tells the Button Listener which image to use for which button
     */
    
    public TimeButtonListener(JButton b, int t){
      button = b;
      time = t;
      status = 0;
    }
    
    /**
     * Method that is triggered everytime button is clicked
     * Gets data from user and stores it
     * @param e 
     */
    
    public void actionPerformed(ActionEvent e){
      
      //checks if the data is being changed in tempTime
      int index = currentSelect.indexOf(1);
      
      if (index != -1){
        if(tempTimes[time][index] == 0){
          tempTimes[time][index] = 1;
        } else{
          tempTimes[time][index] = 0;
        }
      }else{
        System.out.println("We can't find the day selected");
      }
     
     //tells gui when to have the button in "clicked" mode
      if(tempTimes[time][index] == 1){
        button.setSelected(true);
        status = 1;
      }
      
      else{
        button.setSelected(false);
        status = 0;
      }

    }
    

  }
   
   /*-------------------****END OF TIME BUTTON LISTENERS****----------------*/
  
  /**
   * This class is used to trigger events after the main done button is clicked by the user
   * It stores all the information ito the tempTimes 2D array
   * @author Bryant Wu
   */
  private class DoneListener implements ActionListener{
    
    /**
     * This method sets the users available times to tempTimes which stores all of the 
     * users availailities in a 2D array. It then uses the CompatibilityScore object to copare the 
     * users availabiities to all the other students in the system.
     * Finally, it takes user to the next frame
     * @param event
     */
    
    public void actionPerformed(ActionEvent event){
      //scores = new CompatibilityScore();
      lp.setVisible(false);
      user.importAvailabilities(tempTimes);
      CompatibilityScore score = DriverGUI.scores;
      score.addStudent(user);
      System.out.println(score);
      Vector<Student> studentList = score.getNames();
      //**For TESTING**
//      System.out.println("In daypicker, There are " + studentList.size() + " students");
//      System.out.println("The name of that student is " + studentList.get(0).getName());
      new MatchResults().setVisible(true);
    }
  }
  public static void main(String[] args) {
    DayPicker sl = new DayPicker();
    sl.setVisible(true);
    
  }
}

