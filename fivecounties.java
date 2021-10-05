/* Covid program to enter details of the counties with the 5 highest Covid cases and write them to file
Assignment 2    Author: Eithen O'Neil           */
import java.util.*;
import java.io.*;

public class fivecounties
{
   public static void main(String args[]) throws FileNotFoundException, IOException //Handle Exceptions
   {
      //Create objects to open the file and write to it
      //Create and open file for writing
      FileOutputStream fos = new FileOutputStream("fivecounties.txt");
      //Write objects to the file
      ObjectOutputStream os = new ObjectOutputStream(fos);
      
      
      //Create Arraylist for the Covid objects
      ArrayList<Covid> CovidList = new ArrayList<>();
      Scanner keyboardIn = new Scanner(System.in);
      String date; 
      String countyName;
      int noCases, noMales, noFemales, medianAge;
      char response;
          
      
   do
   {
      //Get user input values for each county
      System.out.print("Please enter the Date: ");
      date = keyboardIn.nextLine();
      System.out.print("Please enter the County Name:");
      countyName = keyboardIn.nextLine();
      System.out.print("Please enter the number of cases:");
      noCases = keyboardIn.nextInt();
      System.out.print("Please enter the number of men:");
      noMales = keyboardIn.nextInt();
      System.out.print("Please enter the number of women:");
      noFemales = keyboardIn.nextInt();
      System.out.print("Please enter the median age:");
      medianAge = keyboardIn.nextInt();
      
      
      
      //Add Covid/County object to the ArrayList
      CovidList.add(new Covid(date, countyName, noCases, noMales, noFemales, medianAge));
      
      System.out.println("Do you want to add another County? (Enter 'Y' or 'N')");
      response = keyboardIn.next().charAt(0);
      keyboardIn.nextLine();
      }while(response == 'y' || response == 'Y');
      
      //Write ArrayList to file
      os.writeObject(CovidList);
      
      //Close files/streams
      fos.close();
      os.close();
      
      System.out.println("File successfully created");
      
      
      
   }
}
      
      