//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

//This TrackerScreen is the GUI for the tracker, which allows the user to track budgets, savings, and investments.
public class TrackerScreen extends JFrame implements ActionListener 
{
    //Declare UI components
    JButton submitButton;
    JButton exitButton;
    JTextField nameField;
    JTextField targetField;
    JTextField currentField;
    JTextField descField;
    
    //Constructor
    TrackerScreen () 
    {
        //Set window to exit application when closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Use manual layout positioning
        this.setLayout(null);
        //Set dark blue background color
        this.getContentPane().setBackground(new Color(0x010145));
        
        //Border for title panel
        Border border = BorderFactory.createLineBorder(new Color(0x006ab0), 2);
        
        //Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(150,0,200,30);
        titlePanel.setOpaque(true);
        titlePanel.setBorder(border);
        
        // Create and configure title label
        JLabel titleLabel = new JLabel();
        titleLabel.setHorizontalTextPosition(JLabel.CENTER); // centers
        titleLabel.setText("Edit Tracker.");
        titlePanel.add(titleLabel);
        
        //Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBounds(0,30,500,500);
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        
        //Display user's username
        JLabel userNameLabel = new JLabel();
        userNameLabel.setText("Username: " + FundSave.currentUser.getUserName());
        userNameLabel.setFont(new Font(null, Font.PLAIN, 25));
        userNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(userNameLabel);
        
        //Display user's age
        JLabel ageLabel = new JLabel();
        ageLabel.setText("Age: " +Integer.toString(FundSave.currentUser.getAge()));
        ageLabel.setFont(new Font(null, Font.PLAIN, 25));
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(ageLabel);
        
        //Display user's occupation
        JLabel occupationLabel = new JLabel();
        occupationLabel.setText("Occupation: " + FundSave.currentUser.getOccupation());
        occupationLabel.setFont(new Font(null, Font.PLAIN, 25));
        occupationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(occupationLabel);
        
        //Display user's total investments
        JLabel numInvestLabel = new JLabel();
        numInvestLabel.setText("Number of total investments: " + Integer.toString(FundSave.currentUser.getTotalInvestments()));
        numInvestLabel.setFont(new Font(null, Font.PLAIN, 25));
        numInvestLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(numInvestLabel);
        
        
        //Display current tracker name
        JLabel trackerLabel = new JLabel();
        trackerLabel.setText("Tracker name: " + FundSave.currentTrack.getName());
        trackerLabel.setFont(new Font(null, Font.PLAIN, 25));
        trackerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(trackerLabel);
        
        //Display current target amount
        JLabel targetLabel = new JLabel();
        targetLabel.setText("Target amount: " + FundSave.currentTrack.getTargetAmount());
        targetLabel.setFont(new Font(null, Font.PLAIN, 25));
        targetLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(targetLabel);
        
        //Display current current amount
        JLabel currentLabel = new JLabel();
        currentLabel.setText("Current amount: " + FundSave.currentTrack.getCurrentAmount());
        currentLabel.setFont(new Font(null, Font.PLAIN, 25));
        currentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(currentLabel);
        
        //Tracker Description
        JLabel descLabel = new JLabel();
        descLabel.setText("Description: " + FundSave.currentTrack.getDesc());
        descLabel.setFont(new Font(null, Font.PLAIN, 25));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(descLabel);
        
        //Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        
        //Textfield with placeholder text for better user experience
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250,40));
        nameField.setText(FundSave.currentTrack.getName());
        
        //Textfield for editing target amount
        targetField = new JTextField();
        targetField.setPreferredSize(new Dimension(250,40));
       
        //Textfield for editing current amount
        currentField = new JTextField();
        currentField.setPreferredSize(new Dimension(250,40));

        //If the tracker's target amount is zero, show initial placeholder text        
        if (FundSave.currentTrack.getTargetAmount() == 0) 
        {
            targetField.setText("Target amount");
            currentField.setText("Current amount");
        } 
        
        //Otherwise, 
        else 
        {
            targetField.setText(Double.toString(FundSave.currentTrack.getTargetAmount()));
            currentField.setText(Double.toString(FundSave.currentTrack.getCurrentAmount()));
        }
        

        //TextField
        descField = new JTextField();
        descField.setPreferredSize(new Dimension(250,40));
        descField.setText(FundSave.currentTrack.getDesc());
        
        //Add all text fields and button to body panel
        bodyPanel.add(nameField);
        bodyPanel.add(targetField);
        bodyPanel.add(currentField);
        bodyPanel.add(descField);
        bodyPanel.add(submitButton);
        
        //Exit panel
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new BorderLayout());
        exitPanel.setBounds(0,530,500,30);
        exitPanel.setBackground(new Color(0,0,0,0));
        
        //Back to menu button
        exitButton = new JButton("Back to Menu");
        exitButton.setBounds(400,0,100,30);
        exitButton.setHorizontalAlignment(JButton.RIGHT);
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitPanel.add(exitButton, BorderLayout.EAST);
        
        //Add panels to the Jframe
        this.add(titlePanel);
        this.add(bodyPanel);
        this.add(exitPanel);
        
        //Set size and visibility
        this.setSize(500,560);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    /**
    Handles button click events in the WelcomeScreen interface
    
    Pre-Condition:
    - The WelcomeScreen must be properly initialized with all buttons
    - All button action listeners must be properly registered
    - Required classes (handlingFiles, InvestmentScreen, UserScreen) must be available
    
    Post-Condition:
    - For exitButton: Displays a thank you message and closes the application
    - For button1: Opens file selection dialog to load user data
    - For button2: Opens the investment management screen
    - For button3: Opens the user information screen
    - For button4: Currently no functionality implemented
    - All actions dispose of the current WelcomeScreen window
    
    Parameters:
    - ActionEvent e: The event object containing information about the button click
    
    Return:
    - void: No return value
     */
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //If it equals exit button
        if (e.getSource() == exitButton) 
        {
            //Close screen
            this.dispose();
            
            //Open welcome screen
            new WelcomeScreen();
        } 
        
        //If it equals submit button
        else if (e.getSource() == submitButton) 
        {
            //Use try catch to avoid errors
            try
            {
                //Create new tracker object
                FundSave.currentTrack = new Tracker(nameField.getText(), Double.parseDouble(targetField.getText()), Double.parseDouble(currentField.getText()), descField.getText());
                
                //Close window
                this.dispose();
                
                //Open welcome screen
                new WelcomeScreen();
                
            } 
            
            //Catch NumberFormatException
            catch (NumberFormatException f) 
            {
                //Print error message
                targetField.setText("Invalid input. Try again:");
                currentField.setText("Invalid input. Try again:");
            }
        }
    }
}