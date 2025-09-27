/*
    Names: Alok Mantri, Jordan Lin, Yuriy Neyra Alvarado
    
    Date:August 20th, 2025  
    
    Culminating Activity: FundSave
    
    Description:
    FundSave is a Java program that helps many young adults manage money more effectively by combining
    3 majorfeatures: displaying and searching investment options, tracking budgets/savings, and showing 
    the user's overall financial status. The program will store expenses, investments, and most importantly, 
    user data. File I/O will allow users to save and load their financial information to/from files between 
    sessions. Users can search for stocks by their CUSIP number. There will be a parent Investment class,
    with subclasses Stock, Crypto, and ETF, which demonstrate inheritance and polymorphism. A Swing GUI 
    is going to provide a user-friendly interface with input validation at each step, leaving no room for error. 
*/

//Import swing
import javax.swing.*;


//Import all classes associated with java.io for file reading and writing
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

//Import ArrayList class for ArrayLists and Arrays to set a List
import java.util.ArrayList;


//This FundSave class handles the GUI and method calling of the program
public class FundSave 
{
    //Declare Variables
    
    //Create a 2D arraylist to store investments
    static ArrayList<ArrayList<Investments>> investList = new ArrayList<>(4);
    
    //Create global variable so it is accessible throughout the whole program
    static User currentUser;
    
    //Create global variable so it is accessible throughout the whole program
    static Tracker currentTrack;
    
    //Boolean value to indicate if the user exists
    static boolean userExists = false;
    
    //Main method starts
    public static void main(String[] args) 
    {
        //Add an array to hold each different type of investment: stock, bond, crypto and GIC.
        for (int i = 0; i < 4; i++) 
        {
            investList.add(new ArrayList<Investments>());
        }
        
        
        //Declare Variables
        String[] userLoad = new String[4];
        boolean userCreated = false;
        boolean firstRun = true;
        String stringInput = "";
        
        //Reading off each new line
        try 
        {
            //Create a new object to read from userdata.txt
            BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"));
            stringInput = reader.readLine();
            
            //Check if user is found
            if (stringInput.equals("false")) 
            {
                //If false, print not found message
                firstRun = false;
                new CreateUser("User not found. Enter details:");
                
            } 
            
            //User is found, get user input
            else if (stringInput.equals("true")) 
            {
                userExists = true;
                
                //Loop to put existing user deatils as a user object
                for (int i = 0; i < 10; i++) 
                {
                    //Reading the next lines
                    stringInput = reader.readLine();
                    
                    //userdata.txt is formatted specifically so that any odd number lines will contain key user information
                    

                        if (i % 2 == 1 && i < 8)
                        {
                            //add the relevant data from stringInput
                            userLoad[(i-1)/2] = stringInput;
                        } else if (i == 9 && (stringInput == null || stringInput.isEmpty())) {
                            currentTrack = new Tracker();
                        }
                    
                    
                }   
            } 
            //If there is any other modification to the .txt 
            else 
            {
                firstRun = false;
                new CreateUser("File read error. Enter details: ");
            }
        
            //Close reader resources
            reader.close();
        }
        
        //If an I/O exception is caught
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        
        //If a user is indeed found in the userdata.txt file and this is the first time running the file, the program will call WelcomeScreen. firstRun serves to avoid any additional runs from any prior CreateUser() calls 
        if (userExists && firstRun) 
        {
            //Use try catch to catch errors
            try 
            {
                currentUser = new User(userLoad[0], Integer.parseInt(userLoad[1]), userLoad[2], Integer.parseInt(userLoad[3]));
                userExists = true;
                
                for (int i = 0; i < 11; i++) {
                    
                }
                
                new WelcomeScreen();
            } 
            
            //Catch NumberFormatException 
            catch (NumberFormatException e) 
            {
                new CreateUser("File read error. Enter details: ");
            }
        }
    }
}