//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//This AddStock class is a GUI window that allows the user to enter information about the crypto. 
//It extends Jframe for GUI windows and implements actionList for handling buttons
public class AddStock extends JFrame implements ActionListener 
{
    //Components for GUI
    JButton submitButton;
    JTextField typeField;
    JTextField nameField;
    JTextField symbolField;
    JTextField riskField;
    JTextField priceField;
    JTextField returnField;
    JTextField riskFreeField;
    JTextField stdField;
    JTextField cusipField;
    JTextField sectorField;
    
    //Label for showing instructions
    JLabel topLabel = new JLabel();
    JButton exitButton;
    
    //Used when adding to inventList
    int type = 0;
    
    //Constructor that sets up the GUI components
    AddStock ()
    {
        //Configure Jframe
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        //Top panel with instructions
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0,0,250,150);
        topLabel.setText("Enter stock details: ");
        topPanel.add(topLabel, BorderLayout.NORTH);
        
        //Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        
        //Textfield with placeholder text for better user experience
        typeField = new JTextField();
        typeField.setPreferredSize(new Dimension(250,40));
        typeField.setText("Type");
        
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
        
        cusipField = new JTextField();
        cusipField.setPreferredSize(new Dimension(250,40));
        cusipField.setText("CUSIP Number(Enter a 9 digit number)");
        
        sectorField = new JTextField();
        sectorField.setPreferredSize(new Dimension(250,40));
        sectorField.setText("Sector(Ex.Tech)");

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
        this.add(typeField);
        this.add(nameField);
        this.add(symbolField);
        this.add(riskField);
        this.add(priceField);
        this.add(returnField);
        this.add(riskFreeField);
        this.add(stdField);
        this.add(cusipField);
        this.add(sectorField);
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
        -The method should either save a new stock and open welcome screen again, display an error message, or exit the screen.
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
                this.dispose();
                FundSave.investList.get(type).add(new Stock(Long.parseLong(cusipField.getText()), sectorField.getText(), nameField.getText(), symbolField.getText(), riskField.getText(), Double.parseDouble(priceField.getText()), Double.parseDouble(returnField.getText()), Double.parseDouble(riskFreeField.getText()), Double.parseDouble(stdField.getText())));
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