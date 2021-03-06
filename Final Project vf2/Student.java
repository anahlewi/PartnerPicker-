/*--*--*--*--*--*--*--*--*--*--*--*--*--*--
 * Partner Picker                         *
 * Student.java                           *
 * CS 230 Final Project                   *
 * Anah Lewi, Bryant Wu, Trisha Atluri    *
 * 5/5/17             
 *@author Trishsa Atluri
 *--*--*--*--*--*--*--*--*--*--*--*--*--*-*/

/*
 * Purpose of the Student class is to hold the necessary information regarding all students
 */
public class Student implements Comparable<Student>{
  
  //instance variables
  private String name; 
//  String img; 
//  String email;
  private boolean hasPartner;
  private int[][] availabilities;
  private int tempCompatibilities;

  
  /*
   * constructor method that instantiates the instance variables
   * 
   * @param String that will be the name of the student
   */
  public Student(String n){
      name = n;

      //instantiate availabilities array to 2 weeks and 8am to 10pm with every half hour
      availabilities = new int[28][14]; 
      hasPartner = false;
  }
 
  /*
   * getter method for the name
   * 
   * @return String the name of the student
   */
  public String getName(){
    return name; 
  }
  
  /* 
   * setter method for tempCompatibilities
   * used for when sorting the students
   */
  public void setCompatibilities(int score){
    tempCompatibilities = score;
  }
  
  /*
   * getter method for tempCompatibilities
   *
   * @return int of tempCompatibilities
   */
  public int getCompatibilities(){
    return tempCompatibilities;
  }
  
  /*
   * getter method for availbilities
   * 
   * @return int[][] the 2-d array of availabilities
   */
  public int[][] getAvailabilities(){
    return availabilities; 
  }
  
  /*
   * setter method for the name
   * 
   * @param String which will be the students new name
   */
  public void setName(String newName){
    name = newName;
  }
  
  /*
   * toggles true or false depending on whether they found a partner
   */
  public void foundPartner(){
    hasPartner = true;
  }
  
  /*
   * sets the availbilities for the student
   * 
   * @param int of the time, and int of the day. The integers should correspond to the index of the 2-d array
   */
  public void setTimeAvailable(int time, int day){
    availabilities[time][day] = 1; 
  }
  
  /*
   * another method in which we are aable to set the availibilities for the student, but takes in an entire
   * 2-d array. Used in the GUI when creating students.
   *
   * @param int[][] 2-d array
   */
  public void importAvailabilities(int[][] time){
    try{
      if (availabilities.length == time.length && availabilities[0].length == time[0].length){
        availabilities = time;
      }else{
        System.out.println("Time is not size compatible");
      }
    }
    catch (NullPointerException ex){
      System.out.println("There is an issue with this function");
    }
  }
  
  /*
   * allows comparison based off tempCompatibilities to be made. Used when sorting
   * 
   * @param Student object
   * @return 1,0,-1 depending on whether the student is greater, equal, or less than
   */
  public int compareTo(Student n){
    if (tempCompatibilities < n.getCompatibilities()){
      return -1;
    }else if (tempCompatibilities > n.getCompatibilities()){
        return 1;
      }else{
        return 0;
      }
  }
  
  /*
   * toString method that retunrs the name of the student
   * 
   * @return String "name"
   */
  public String toString(){
    return name;
  }
}



    
    
    
  

