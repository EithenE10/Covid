/* Covid class to record daily covid case numbers 
Assignment 2               */
import java.io.*;

public class Covid implements Serializable
{
   private String date;
   private String countyName;
   private int noCases;
   private int noMales;
   private int noFemales;
   private int medianAge;
   
   //Constructors
   //Constructor 1 - User defined default
   public Covid()
   {
      date = " ";
      countyName = " ";
      noCases = 0;
      noMales = 0;
      noFemales = 0;
      medianAge = 0;
   }
   
   //Constructor 2 - Parameter defined constructor (Add IllegalArgument Exception for illegal ints)
   public Covid(String dt, String county, int cases, int males, int females, int age) throws IllegalArgumentException
   {
      if(cases < 0 || males < 0 || females < 0 || age < 0)
      {
         throw new IllegalArgumentException();
      }
      else
   {
      date = dt;
      countyName = county;
      noCases = cases;
      noMales = males;
      noFemales = females;
      medianAge = age;
   }
   }
   
   //Methods
   //Set methods Mutator methods
   public void setDate(String dt)
   {
      date = dt;
   }
   public void setCountyName(String county)
   {
      countyName = county;
   }
   public void setNoCases(int cases)
   {
      noCases = cases;
   }
   public void setNoMales(int males)
   {
      noMales = males;
   }
   public void setNoFemales(int females)
   {
      noFemales = females;
   }
   public void setAge(int age)
   {
      medianAge = age;
   }
   //Accessor methods
   public String getDate()
   {
      return date;
   }
   public String getCountyName()
   {
      return countyName;
   }
   public int getNoCases()
   {
      return noCases;
   }
   public int getNoMales()
   {
      return noMales;
   }
   public int getNoFemales()
   {
      return noFemales;
   }
   public int getAge()
   {
      return medianAge;
   }
   public String toString()
   {
      return "Date: "+date+"\n"+"County:"+countyName+"\n"+"No of Cases:"+noCases+"\n"+ "No Males:"+noMales+"\n"+
      "No Females:"+noFemales+ "\n"+ "Median Age:"+medianAge+"\n";
   } 
}