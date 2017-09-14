import java.util.*;
import java.io.*;
import javafoundations.*;
/********************************************************************
  *  CS230 Final Project 
  *  DriverGUI.java  (Driver Class for PartnerPicker)
  * 
  *  Runs the Program
  *
  *  @authors Anah Lewi, Trisha Atluri, & Bryant Wu
  *  @date May 5, 2017
  * 
  * 
  * Modified by Bryant Wu for PartnerPicker Application
  *********************************************************************/


public class DriverGUI{
  public static CompatibilityScore scores;
  
  public static void main(String[] args){
    scores = new CompatibilityScore();
    
    LandingPage l = new LandingPage();
    l.setVisible(true);
  }
}
    
    

  