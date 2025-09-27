// Imports necessary packages for GUI components and events
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// CreateUser class extends Jframe implements actionlistener
public class CreateUser extends JFrame implements ActionListener 
{
    
    // UR components declaring
    JButton submitButton;
    JTextField userNameField;
    JTextField ageField;
    JTextField occupationField;
    JTextField numInvestField;
    JLabel topLabel = new JLabel();
    
    // Variables to store user input values
    private String newUsername;
    private int newAge;
    private String newOccupation;
    
    // Constructor 
    CreateUser (String prompt) 
    {
        //Configure Jframe 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        //Create top panel
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0,0,250,150);
        topLabel.setText(prompt);
        topPanel.add(topLabel, BorderLayout.NORTH);
        
        //Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        
        //Input field to enhance user experience
        userNameField = new JTextField();
        userNameField.setPreferredSize(new Dimension(250,40));
        userNameField.setText("Username");
        
        ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(250,40));
        ageField.setText("Age");
        
        occupationField = new JTextField();
        occupationField.setPreferredSize(new Dimension(250,40));
        occupationField.setText("Occupation");
        
        //Add componenets to Jframe
        this.add(topPanel);
        this.add(userNameField);
        this.add(ageField);
        this.add(occupationField);
        this.add(submitButton);
        
        //Set size and visibility
        this.setSize(250,300);
        this.setResizable(false);
        this.setVisible(true);
    }

    /*
    Handles user input when the submit button is clicked
    Pre-Condition:
        - All text fields must contain valid input values
        - The username field must not be empty
        - The age field must contain a valid integer value
        - The occupation field must not be empty
    Post-Condition:
        - If all inputs are valid, creates a new User object
        - Sets the currentUser in FundSave to the newly created user
        - Sets userExists flag to true
        - Closes the current window and opens the WelcomeScreen
        - If age input is invalid, displays an error message
    Parameters:
        - ActionEvent e: The event triggered by clicking the submit button
    Return:
        - void: No return value
    */
    
    //Override the method from the parent class
    @Override
    public void actionPerformed(ActionEvent e)
    {   
        //Check if it is submit button
        if(e.getSource() == submitButton)
        {
            //Get text input
            newUsername = userNameField.getText();
            newOccupation = occupationField.getText();
            
            //Use try catch to avoid errors
            try
            {
                // Parse age as integer
                newAge = Integer.parseInt(ageField.getText());
                
                //create new user object with the entered information
                FundSave.currentUser = new User(newUsername, newAge, newOccupation);
                this.dispose();
                FundSave.userExists = true;

                FundSave.currentTrack = new Tracker();
                for (int i = 0; i < 4; i++) {
                    FundSave.investList.get(i).clear();
                }
                
                //Open welcome screen
                new WelcomeScreen();
                
            } 
            
            //Catch NumberFormatException
            catch (NumberFormatException f) 
            {
                //Print error message
                topLabel.setText("Invalid input. Try again:");
            }
        }
        
    }
    
}