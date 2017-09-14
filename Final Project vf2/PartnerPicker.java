import java.util.*;
import javafoundations.*;

/********************************************************************
  *  CS230 Final Project 
  *  PartnerPicker.java  (Main Class for PartnerPicker)
  * 
  *  Implements algorithm that uses the CompatibilityScore object in order to find 
  *  a list of compatible partners for user
  *
  *  @authors Anah Lewi, Trisha Atluri, & Bryant Wu
  *  @date May 5, 2017
  * 
  * 
  * Modified by Bryant Wu for PartnerPicker Application
  *********************************************************************/

public class PartnerPicker{
  
    //instance variables
    private CompatibilityScore scores;
    
    
      /******************************************************************
    * Constructor
    * 
    * @param s: takes a CompatibilityScore object 
    * instantiates variables scores by setting it equal to parameter s 
    * ***********************************/
    public PartnerPicker(CompatibilityScore s){
        scores = s;
        
    }
     /******************************************************************
    * Takes student parameter and returns sorted list based on compatibility 
    * 
    * @param s: current student name as Student object 
    * @return vector of students 
    ******************************************************************/
    public Vector<Student> matchResults(Student s){
      
      Vector<Student> names = scores.getNames();
      LinkedList<Integer> scoreList = scores.getIndividualScores(s);
      Vector<Student> output = new Vector<Student>();
      
      //puts the compatbilities into student objects
      for(int i = 0; i<names.size();i++){
        names.get(i).setCompatibilities(scoreList.get(i));
      }
      
      MaxHeap<Student> sorter = new LinkedMaxHeap<Student>();
      
      //adds to maxheap
      for(int i = 0; i<names.size(); i++){
        sorter.add(names.get(i));
      }      
      
      //removes and adds sorted sequence to vector
      for(int i = 0; i<names.size()-1; i++){
        output.add(sorter.removeMax());
      }

      
      //removes the last index because that is where the student iself will be stored
      //sortedStuds.remove(sortedStuds.size()-1);
      
      
      System.out.println(output);
      return output;
      
      
    }
    
      /******************************************************************
    * Driver 
    * 
    * Test Cases
    ******************************************************************/

    public static void main(String [] args){
      
//      CompatibilityScore s = new CompatibilityScore();
//      PartnerPicker test1 = new PartnerPicker(s);
//      Student a = new Student("a");
//      Student b = new Student("b");
//      Student c = new Student("c");
//      Student d = new Student("d");
//      Student e = new Student("e");
//      Student f = new Student("f");
//      Student g = new Student("g");
//      Student h = new Student("h");
//      Student i = new Student("i");
//      Student j = new Student("j");
//      
//      for(int k= 0; k < 10; k++){
//        a.setTimeAvailable(k, 1);
//        c.setTimeAvailable(k + 1, 1);
//        b.setTimeAvailable(1, k);
//      }
//      
//      
//      
//      s.addStudent(a);
//      s.addStudent(b);
//      s.addStudent(c);
//      s.addStudent(d);
//      s.addStudent(e);
//      s.addStudent(f);
//      s.addStudent(g);
//      s.addStudent(h);
//      s.addStudent(i);
//      s.addStudent(j);
      
//      System.out.println(s);
//      
//      for(int z=0; z<10; z++){
//        a.setTimeAvailable(2,z);
//        b.setTimeAvailable(2,z);
//      }
//      
//      test1.matchResults(a);
//      
//      s.updateAvailability(a);
//      s.updateAvailability(b);
//      s.updateAvailability(d);
//      
//      System.out.println(s);
//
////  
//      s.removeStudent(b);
//     System.out.println(s);
//      
//
//      test1.matchResults(a);
//      test1.matchResults(c);
      
      
      
      
        
    }
    
    
}