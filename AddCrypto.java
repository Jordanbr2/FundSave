//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//This AddCrypto class is a GUI window that allows the user to enter information about the crypto. 
//It extends Jframe for GUI windows and implements actionList for handling buttons
public class AddCrypto extends JFrame implements ActionListener 
{
    //Components for GUI
    JButton submitButton;
    JTextField nameField;
    JTextField symbolField;
    JTextField riskField;
    JTextField priceField;
    JTextField returnField;
    JTextField riskFreeField;
    JTextField stdField;
    JTextField blockField;
    JTextField categoryField;
    
    //Label for showing instructions
    JLabel topLabel = new JLabel();
    JButton exitButton;
    
    //Used when adding to inventList
    int type = 2;
    
    //Constructor that sets up the GUI components
    AddCrypto () 
    {
        //Configure Jframe
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        //Top panel with instructions
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0,0,250,150);
        topLabel.setText("Enter crypto details: ");
        topPanel.add(topLabel, BorderLayout.NORTH);
        
        //Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        
        //Textfield with placeholder text for better user experience
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250,40));
        nameField.setText("Name");
        
        symbolField = new JTextField();
        symbolField.setPreferredSize(new Dimension(250,40));
        symbolField.setText("Symbol of asset(ex.AAPL)");
        
        riskField = new JTextField();
        riskField.setPreferredSize(new Dimension(250,40));
        riskField.setText("Risk(Enter low, medium, high)");

        priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(250,40));
        priceField.setText("Price(Enter the latest price of the asset)");
        
        returnField = new JTextField();
        returnField.setPreferredSize(new Dimension(250,40));
        returnField.setText("Expected Return (Average Return of the asset)");
        
        riskFreeField = new JTextField();
        riskFreeField.setPreferredSize(new Dimension(250,40));
        riskFreeField.setText("Risk Free Rate");
        
        stdField = new JTextField();
        stdField.setPreferredSize(new Dimension(250,40));
        stdField.setText("Standard Deviation");

        blockField = new JTextField();
        blockField.setPreferredSize(new Dimension(250,40));
        blockField.setText("Blockchain(Ex.Ethereum)");
        
        categoryField = new JTextField();
        categoryField.setPreferredSize(new Dimension(250,40));
        categoryField.setText("Category");

        //Exit panel
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new BorderLayout());
        exitPanel.setBounds(0,650,250,50);
        exitPanel.setBackground(new Color(0,0,0,0));
        exitButton = new JButton("Cancel"); 
        exitButton.setBounds(400,0,100,30);
        exitButton.setHorizontalAlignment(JButton.RIGHT);
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitPanel.add(exitButton, BorderLayout.EAST);
        
        //Adding components to the Jframe
        this.add(topPanel);
        this.add(nameField);
        this.add(symbolField);
        this.add(riskField);
        this.add(priceField);
        this.add(returnField);
        this.add(riskFreeField);
        this.add(stdField);
        this.add(blockField);
        this.add(categoryField);
        this.add(submitButton);
        this.add(exitPanel);

        //Set size and visibility
        this.setSize(250,700);
        this.setResizable(false);
        this.setVisible(true);
    }

    /*
    This actionPerformed handles user interactions pertaining to the save and exit buttons.
    Pre-Condition:
        -The GUI must have initialized all its attributes.
        -The user must provide a valid input within the text field. 
    Post-Condition:
        -The method should either save a new crypto and open welcome screen again, display an error message, or exit the screen.
    Parameters:
        -e(the event triggered when button clicked)
    Return:
        -None
    */
    
    //Override the method from parent class
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Check if it is a submit button
        if(e.getSource() == submitButton) 
        {
            //Use try catch to avoid errors
            try 
            {
                //create a new crypto object
                FundSave.investList.get(type).add(new Crypto(blockField.getText(), categoryField.getText(), nameField.getText(), symbolField.getText(), riskField.getText(), Double.parseDouble(priceField.getText()), Double.parseDouble(returnField.getText()), Double.parseDouble(riskFreeField.getText()), Double.parseDouble(stdField.getText())));
                this.dispose();
                new WelcomeScreen();
                
                
            } 
            
            //Catch NumberFormatException exception
            catch (NumberFormatException f) 
            {
                //Display error message
                topLabel.setText("Invalid input. Try again:");
            }
        }
        
        //Check if it is an exit button
        else if (e.getSource() == exitButton)  
        {
            this.dispose();
            new InvestmentScreen();
            
        }
        
    }
    
}