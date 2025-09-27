import java.io.*;
import java.util.*;

// Main Tracker class
class Tracker 
{
    protected String name;
    protected double targetAmount;
    protected double currentAmount;
    protected String description;
    protected String tempString = "";
    
    public Tracker () 
    {
        this.name = "Enter Tracker Name";
        this.targetAmount = 0;
        this.currentAmount = 0;
        this.description = "Enter description";
    }
    
    //Counter variable set at 8 (to manage everything after the SKU, as SKU is set to 8 characters)
    private int k = 0;
    
    //Method to set the string attributes: name and description
    public String stringSet(String initString) 
    {
        //Empty the string
        this.tempString = "";
        
        //Cycle through each proceeding character in the string from the previous comma, and save the characters to tempString
        for (int i = k + 1; i < initString.length(); i++) 
        {
            //Once the next attribute is found by a comma
            if (initString.charAt(i) == ',') 
            {
                //Set k to i to use in the next iteration
                k = i;
                
                //break the for loop to save time and not mess up k's value
                break;
            }
            
            //Add the non-comma characters to tempString
            this.tempString = this.tempString + initString.charAt(i);
        }
        
        //Once the attribute has been fully listed and copied to tempString, return it
        return tempString;
    }
    
    //Method to set the double attributes
    public double doubleSet(String initString) 
    {
        //Empty the string
        this.tempString = "";
        
        //Cycle through each proceeding character in the string from the previous comma, and save the characters to tempString
        for (int i = k + 1; i < initString.length(); i++) 
        {
            //Once the next attribute is found by a comma
            if (initString.charAt(i) == ',') 
            {
                //Set k to i to use in the next iteration
                k = i;
                //break the for loop to save time and not mess up k's value
                break;
            }
            
            //Add the non-comma characters to tempString
            this.tempString = this.tempString + initString.charAt(i);
        }
        
        //Once the attribute has been fully listed and copied to tempString, convert to an integer and return it
        return Double.parseDouble(tempString);
    }
    
    public Tracker (String initString) 
    {
        this.name = stringSet(initString);
        this.targetAmount = doubleSet(initString);
        this.currentAmount = doubleSet(initString);
        this.description = stringSet(initString);
    }
    
    public Tracker(String name, double targetAmount, double currentAmount, String description) 
    {
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.description = description;
        
        
    }

    //Getter methods
    public String getName() 
    {
        return name;
    }
    
    public double getTargetAmount() 
    {
        return targetAmount;
    }

    public double getCurrentAmount() 
    {
        return currentAmount;
    }
    
    public String getDesc() 
    {
        return description;
    }
    
    @Override
    public String toString() 
    {
        return name + "," + targetAmount + "," + currentAmount + "," + description;
    }
    
    
}