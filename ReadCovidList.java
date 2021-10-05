/*Program to read object of Covid class back in from file as ArrayList*/

import java.io.*;
import java.util.*;
public class ReadCovidList
{
   public static void main(String[]args) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      Scanner keyboardIn = new Scanner(System.in);
      //Create objects to open file and read from it
      FileInputStream fis = new FileInputStream("fivecounties.txt");
      ObjectInputStream in = new ObjectInputStream(fis);
      
      //Create ArrayList to catch objects from file
      ArrayList<Covid> CovidList = (ArrayList<Covid>) in.readObject();
      
      //Search for information by county
      String searchCounty;
      System.out.print("Enter County name to see statistics:");
      searchCounty = keyboardIn.nextLine();
      for(int i = 0; i < CovidList.size(); i++)
      {
         if(searchCounty == CovidList.get(i).getCountyName())
         {
            System.out.println(CovidList.get(i));
         }
      
      
      
      
      //Print ArrayList to screen
      //for(Covid Covid1 :CovidList) 
     // {
       //  System.out.println(Covid1);
      }    
      
   }
}
      
    