//Import
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

//This WelcomeScreen is the GUI for the main menu, which allows the user to navigate through different features.
public class WelcomeScreen extends JFrame implements ActionListener 
{
    //Buttons
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton exitButton;
    JButton resetButton;
    
    //Constructor
    WelcomeScreen() 
    {
        //Configure behaviour
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x010145));
        
        //Border for panels
        Border border = BorderFactory.createLineBorder(new Color(0x006ab0), 2);
        
        //Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(150,0,200,30);
        titlePanel.setOpaque(true);
        titlePanel.setBorder(border);
        
        
        JLabel titleLabel = new JLabel();
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setText("Welcome to FundSave.");
        titlePanel.add(titleLabel);
        
        //Body Panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout(0, 1, 0, 20));
        bodyPanel.setBounds(0,30,500,500);
        
        //Load file button
        button1 = new JButton("Load File");
        button1.setPreferredSize(new Dimension(200, 50));
        button1.addActionListener(this);
        button1.setFocusable(false);
        
        //Investments button
        button2 = new JButton("Investments");
        button2.setPreferredSize(new Dimension(200, 50));
        button2.addActionListener(this);
        button2.setFocusable(false);
        
        //User information button
        button3 = new JButton("User Information");
        button3.setPreferredSize(new Dimension(200, 50));
        button3.addActionListener(this);
        button3.setFocusable(false);
        
        //Tracking budget, savings, or investment button
        button4 = new JButton("Track Budget, Savings, or Investment");
        button4.setPreferredSize(new Dimension(200, 50));
        button4.addActionListener(this);
        button4.setFocusable(false);
        
        //Add button to the body panel
        bodyPanel.add(button1);
        bodyPanel.add(button2);
        bodyPanel.add(button3);
        bodyPanel.add(button4);
        
        //Exit panel with save and exit
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new BorderLayout());
        exitPanel.setBounds(0,530,500,30);
        exitPanel.setBackground(new Color(0,0,0,0));
        exitButton = new JButton("Save and Exit");
        exitButton.setBounds(400,0,100,30);
        exitButton.setHorizontalAlignment(JButton.RIGHT);
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitPanel.add(exitButton, BorderLayout.EAST);
        
        
        resetButton = new JButton("Reset Data");
        resetButton.setBounds(400,0,100,30);
        resetButton.setHorizontalAlignment(JButton.LEFT);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        exitPanel.add(resetButton, BorderLayout.WEST);
        
        //Add panels to the Jframe
        this.add(titlePanel);
        this.add(bodyPanel);
        this.add(exitPanel);
        
        //Set size and visibility
        this.setSize(500,560);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    /*
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
        //If save and exit button is clicked
        if (e.getSource() == exitButton) 
        {
            //Display thank you message
            JOptionPane.showMessageDialog(null, "Thank you for using this tool. Have a good day!", "Exit", JOptionPane.PLAIN_MESSAGE);
            
            //Close widnow
            this.dispose();
        } 
        
        else if (e.getSource() == resetButton) {
            int temp = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            switch (temp) {
                case 0:
                    //Close window
                    this.dispose();
                    
                    new CreateUser("Enter new user data: ");
                    
                    break;
                case 1:
                    break;
            }
            
        }
        
        //If load file button is clicked
        else if (e.getSource() == button1) 
        {
            //Close window
            this.dispose();
            
            //Read the file
            HandlingFiles.readNewFile();
            
            //Exit method
            return;
        }
        
        //If user add investments button is clicked
        else if (e.getSource() == button2) 
        {
            //Close window
            this.dispose();
            
            //Open investment screen
            new InvestmentScreen();
        }
        
        
        //If user information button is clicked
        else if (e.getSource() == button3) 
        {
            //Close window
            this.dispose();
            
            //Open user screen
            new UserScreen();
        }
        //If tracking budget, savings, or investments button is clicked
        else if (e.getSource() == button4) 
        {
            //Close window
            this.dispose();
            
            //Open tracking screen
            new TrackerScreen();
        }
        
    }
    
}