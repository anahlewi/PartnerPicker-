/*-----------------------------------------------
 * Partner Picker 
 * CompatibilityScore.java 
 * CS 230 Final Project
 * Anah Lewi, Bryant Wu, Trisha Atluri
 * 5- 5- 2017
 * @author Bryant Wu
 -------------------------------------------------*/
import java.util.*;

/*
 * Purpose of compatabilityscore is to hold all the compatability score data for all students
 * This information will be pulled when creating a sorted list of students
 */
public class CompatibilityScore{
  
  //instance variable
  private Vector<Student> name;
  private Vector<LinkedList<Integer>> compatabilityScore;
  
  //constructor
  public CompatibilityScore(){
    name = new Vector<Student>();
    compatabilityScore = new Vector<LinkedList<Integer>>();
  }
  
  /*
   * Adds a student to the vector array and adds his compatability score into the compatabilityScore LinkedList
   * 
   * @param Student objects
   */
  public void addStudent(Student n){
    compatabilityScore.add(new LinkedList<Integer>());
    name.add(n);
    calculateScores(n);
  }
  
  /*
   * calculates the score for the particular student and changes all the respective parts of  the score
   * scores are incremented by 1 for every 30 min block they have matched up
   *
   * @param Student objects
   */
  private void calculateScores(Student n){
    
    //if its the first student added he/she will have a score of -1 
    if(name.size() == 1){
      compatabilityScore.get(0).add(-1);
      System.out.println("This should run once");
      return;
    }
    
    int index = name.indexOf(n);
    
    //adds the scores for the horizontal row
    for(int i = 0; i<name.size()-1; i++){
      int inputScore = findScores(n, name.get(i));
      compatabilityScore.get(index).add(inputScore);
    }
    
    //adds the score for the vertical row
    for (int i = 0; i<name.size(); i++){
      int inputScore = findScores(n, name.get(i));
      compatabilityScore.get(i).add(inputScore);
    }
  }
  
  /*
   * @returns the vector of names
   */
  public Vector<Student> getNames(){
    return name;
  }
  
  /*
   * @returns the linkedlist of the scores for one of the students
   */
  public LinkedList<Integer> getIndividualScores(Student n){
    int index = -1;
    for(int i = 0; i < name.size(); i++){
      if (name.get(i).getName().equals(n.getName())){
        index = i;
        break;
      }
    }
    System.out.println("this is the index " + index);
    return compatabilityScore.get(index);
  }
  
  
  
  /*
   * Finds the compatibility scores of the two students
   * 
   * @param 2 Student objects
   * @return score in type int
   */
  private int findScores(Student n, Student k){
    
    //if the Students are the same, then return -1 immediately
    if (n == k){
      int counter = -1;
      return counter;
    }
    
    int[][] nArray = n.getAvailabilities();
    int[][] kArray = k.getAvailabilities();
    
    int counter = 0;
    
    for (int i = 0; i<nArray.length; i++){
      for (int j = 0; j <nArray[i].length; j++){
        if (nArray[i][j] == 1 && kArray[i][j] == 1){
          counter++;
        }
      }
    }
    return counter;
  }
  
  /*
   * removes student from the linkedlists and adjusts the numbers accordingly
   */
  public void removeStudent(Student s){
    int index = -1;
    for(int i = 0; i < name.size(); i++){
      if (name.get(i).getName().equals(s.getName())){
        index = i;
        break;
      }
    }
        //int index = name.indexOf(s);
        name.remove(index);
        compatabilityScore.remove(index);
        
        for (int i = 0; i<name.size(); i++){
          compatabilityScore.get(i).remove(index);
        }
      }
      
  /*
   * update a students availabilities
   */
  public void updateAvailability(Student s){
    if (name.contains(s)){
      removeStudent(s);
      addStudent(s);
    } else{
      System.out.println("Student does not exist in our records");
    }
  }

  
  /*
   * checks if the student is in the vector name
   * 
   * @param takes in a Student object
   * @return returns boolean value based off whether the student is in or not
   */
  public boolean isStudent(Student user){
    String n = user.getName();
    for (int i = 0; i<name.size(); i++){
      if (n.equals(name.get(i).getName())){
        return true;
      }
    }
    return false;
    
  }
  /*
   * toString method that prints out the results 
   * "Bryant: -1 10 5 
   * "Anah: 10 -1 6
   * "Trisha: 5 6 -1
   */
  public String toString(){
    String s = "";
    for (int i = 0; i<name.size(); i++){
      s += name.get(i).getName() + ": ";
      s += compatabilityScore.get(i) + "\n";
    }
    return s;
  }
  
  
  public static void main(String [] args){
    CompatibilityScore test1 = new CompatibilityScore();
    System.out.println(test1);
    
  }
  
  
}