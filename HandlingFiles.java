//Import all classes associated with java.io for file reading and writing
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

//Import ArrayList class for ArrayLists and Arrays to set a List
import java.util.ArrayList;
import javax.swing.*;
import java.io.File;
 
//This class handles all the tasks about reading and writing files.
public class HandlingFiles
{

    /*
    This saveNewUser method, when a new user must be entered, will save the user details to a temporary file
    Pre-Condition:
        -A valid user object must be passed in
    Post-Condition:
        -The method correctly save user details to a file.
    Parameters:
        -user(the user object)
    Return:
        -None
    */
    public static void setTracker() {
        
    }
    
    
    public static void saveNewUser(User user) 
    {
        //Use try cactch to 
        try 
        {
            //Create a bufferedwriter object to write to userdata
            BufferedWriter writer = new BufferedWriter (new FileWriter("userdata.txt"));
            
            //Create a new line for every item object and paste the toString() method
            //This rewrites the file exactly as it is formatted
            writer.write(user.toString());
            
            
            //Close writer resources
            writer.close();
        } 
        
        //Catch IOException error
        catch (IOException e) 
        {
            //Print error message
            e.printStackTrace();
        }
    }
    
    /*
    DONT know what you gonna change so leave it like this for now
    This readNewFile method is a method that reads file 
    Pre-Condition:
        -A valid user object must be passed in
    Post-Condition:
        -The method correctly save user details to a file.
    Parameters:
        -user(the user object)
    Return:
        -None
    */
    
    public static void readNewFile() 
    {
        String[] userLoad = new String[4];
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            
            String stringInput = "";
            //Reading off each new line
            try 
            {
                //Create a new object to read from userdata.txt
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                stringInput = reader.readLine();
                
                if (stringInput.equals("false")) 
                {
                    FundSave.userExists = false;
                    new CreateUser("User not found. Enter details:");
                    
                } 
                else if (stringInput.equals("true")) 
                {
                    for (int i = 0; i < 8; i++) 
                    {
                        stringInput = reader.readLine();
                        
                        if (i % 2 == 1) 
                        {
                            userLoad[(i-1)/2] = stringInput;
                        }
                    }   
                } 
                else 
                {
                    new WelcomeScreen();
                }
                
                //Close reader resources
                reader.close();
                
                try 
                {
                    FundSave.currentUser = new User(userLoad[0], Integer.parseInt(userLoad[1]), userLoad[2], Integer.parseInt(userLoad[3]));
                    FundSave.userExists = true;
                    
                    new WelcomeScreen();
                } 
                catch (NumberFormatException e) 
                {
                    FundSave.userExists = false;
                    new CreateUser("File read error. Enter details: ");
                }
            } 
            
            //If an I/O exception is caught
            catch (IOException e) {
                
                e.printStackTrace();
            }
                
        } 
        
        else 
        {
            new WelcomeScreen();
        }
    }
}