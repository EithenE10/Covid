/*Program/App to process Covid statistics. Assignment 2. 
Author - Eithen O'Neil    L00162818 */

import java.io.*;
import java.util.*;
import java.util.Collections;
public class ReadCovidMenu
{
   public static void main(String[]args) throws FileNotFoundException , IOException, ClassNotFoundException //Add Exception Handling
   {
      Scanner keyboardIn = new Scanner(System.in);
      //Create objects to open file and read from it
      FileInputStream fis = new FileInputStream("fivecounties.txt");
      ObjectInputStream os = new ObjectInputStream(fis);
      
      ArrayList<Covid>CovidList = (ArrayList<Covid>) os.readObject();

      int option;
      do
      {
         //Display Menu
         System.out.println("***********Covid Processing System***********");
         System.out.println("1. View all data for all 5 counties");
         System.out.println("2. View data by County");
         System.out.println("3. Find County with highest number of cases");
         System.out.println("4. Calculate Average age");
         System.out.println("5. Write all details of the county with the lowest number of cases to new file");
         System.out.println("0. Exit System");
         System.out.print("Enter your option");
         option = keyboardIn.nextInt();
         
         switch(option)
         {
            case 1:
            viewallCounties(CovidList); //Call method 1 - viewallCounties and pass it to the ArrayList
            break;
            
            case 2:
            //Ask user to enter the County Name
            System.out.print("Enter County name to show details: ");
            keyboardIn.nextLine();
            String searchCounty = keyboardIn.next();
            //Call method 2-  searchCounty
            searchCountyname(CovidList, searchCounty);
            break;
            
            case 3:
            highestCountycases(CovidList); // Call method 3 - highestCountycases 
            break;
            
            
            case 4:
            displayaverageage(CovidList); // Call method 4 - displayaverageage
            break;
            
            
            case 5:
            lowestcountycases(CovidList); // Call method 5 - lowerstcountycases
            break;
       
          }//Close switch statement
         
        
       }while(option != 0);
         
      
   }//close main method 
  
  
   //Method to view data for all Counties Cases
   public static void viewallCounties(ArrayList<Covid> CovidList) throws IOException, ClassNotFoundException
   {
      for(Covid Covid1: CovidList)
      {
         System.out.println(Covid1);
      }
   }//Close Method
   
  
  
  //Method to search for case information based on County
  public static void searchCountyname(ArrayList<Covid> CovidList, String countyID) throws IOException, ClassNotFoundException
  {
     boolean countyFound = false;
     for(int i = 0; i < CovidList.size(); i++)
     {
        if(countyID.equalsIgnoreCase(CovidList.get(i).getCountyName()))
        {
           System.out.println(CovidList.get(i));
           countyFound = true;
        }
     }//close for
     if(countyFound == false)
     {
      System.out.println("No information on this county can be found");
     }
  }//close method
  
  
  //Method to Find County with the Highest Number of Cases
  public static void highestCountycases(ArrayList<Covid> CovidList) throws IOException, ClassNotFoundException
  {
      //Declare variable for highestCases and set it to 1st element of array list
      int highestCases = CovidList.get(0).getNoCases();
      String cname = " "; //hold county name with highest cases
      
      for(int i = 0; i < CovidList.size(); i++)
      {
         if(CovidList.get(i).getNoCases() > highestCases)
         {
            highestCases = CovidList.get(i).getNoCases();
            cname = CovidList.get(i).getCountyName();
         }
      }//Close for loop
      //Print name of employee
      System.out.println(cname + " is the county with the highest number of cases totalling "+highestCases+  " \nCases.");
  }// close method
  
  
  
  
  
  //Method to Calculate average age of all cases
  public static void displayaverageage(ArrayList<Covid> CovidList) throws IOException, ClassNotFoundException
  {
     //Create the array
     int [] ages = new int [5];
     int totalages = 0;
     int avgageall;
     
     //Populate the array
     for(int i = 0; i < CovidList.size(); i++)
     
      {
         //Get all of all counties, add up and divide by 5.
         CovidList.get(i).getAge();
         ages[i] = CovidList.get(i).getAge();
         totalages = totalages + ages[i];
      }
      
      avgageall = totalages / 5;
      //Display total ages
      System.out.println("Median age of all 5 counties is:" +avgageall);
   }  
     
     
     
   //Method to write all details of the county with the lowest number of cases to new file
   public static void lowestcountycases (ArrayList<Covid> CovidList) throws FileNotFoundException, IOException
      {
        //Declare variable for lowestcases and set it to 1st element of array list
        int lowestCases = CovidList.get(0).getNoCases();
        String cname = " ";//hold county name with lowest cases
        String date = " ";
        int nocases = 0;
        int nomales = 0;
        int nofemales = 0;
        int avgage = 0;
        
        
        for(int i = 0; i < CovidList.size(); i++)
      {
         if(CovidList.get(i).getNoCases() <= lowestCases)
         {
            cname = CovidList.get(0).getCountyName();
            lowestCases = CovidList.get(i).getNoCases();
            date = CovidList.get(0).getDate();
            nocases = CovidList.get(i).getNoCases();
            nomales = CovidList.get(i).getNoMales();
            nofemales = CovidList.get(i).getNoFemales();
            avgage = CovidList.get(i).getAge();
            
         }
      }//Close for loop
      System.out.println(cname + " is the county with the lowest amount of cases totalling: "+lowestCases+  "\nCases."+ "\nDate:"+date+  "\nNo Cases:"+nocases+  "\nNo Males:"+nomales+
       "\nNo Females:"+nofemales+  "\nAverage Age:"+avgage);
       
       
    //Print details of the county to a new file
    FileOutputStream fos = new FileOutputStream("lowestcountycases.txt");
    //Write objects out to file
    ObjectOutputStream os = new ObjectOutputStream(fos);
    
    //Write County Details to file
    os.writeObject(cname);
    os.writeObject(date);
    os.writeObject(nocases);
    os.writeObject(nomales);
    os.writeObject(nofemales);
    os.writeObject(avgage);
      
    //Close files/streams
    fos.close();
    os.close();
      
    System.out.println("File successfully created");
      }//Close Method 5




  
}//Close program

  
    