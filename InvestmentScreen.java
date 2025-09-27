//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class InvestmentScreen extends JFrame implements ActionListener 
{
    //Declare buttons for different investment options
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton exitButton;
    
    //Constructor
    InvestmentScreen() 
    {
        //Set window to exit application when closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Use absolute positioning for components
        this.setLayout(null);
        
        //Set background color of the pane
        this.getContentPane().setBackground(new Color(0x010145));
        
        //Creates a blue border for style
        Border border = BorderFactory.createLineBorder(new Color(0x006ab0), 2);
        
        //Create title panel at top of the window
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(150,0,200,30); //Position and size
        titlePanel.setOpaque(true); //sets it to visible
        titlePanel.setBorder(border); //Apply border styling
        
        //Create and configure title label
        JLabel titleLabel = new JLabel();
        titleLabel.setHorizontalTextPosition(JLabel.CENTER); //Center text
        titleLabel.setText("Investment Options."); //Set label text
        titlePanel.add(titleLabel); //Add label to panel
        
        //Create add asset buttons
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout(0, 1, 0, 20));
        bodyPanel.setBounds(0,30,500,500);
        button1 = new JButton("Add Stock");
        button1.setPreferredSize(new Dimension(200, 50));
        button1.addActionListener(this);
        button1.setFocusable(false);
        button2 = new JButton("Add Bond");
        button2.setPreferredSize(new Dimension(200, 50));
        button2.addActionListener(this);
        button2.setFocusable(false);
        button3 = new JButton("Add Crypto");
        button3.setPreferredSize(new Dimension(200, 50));
        button3.addActionListener(this);
        button3.setFocusable(false);
        button4 = new JButton("Add GIC");
        button4.setPreferredSize(new Dimension(200, 50));
        button4.addActionListener(this);
        button4.setFocusable(false);
        
        //Add all 4 buttons to body panel
        bodyPanel.add(button1);
        bodyPanel.add(button2);
        bodyPanel.add(button3);
        bodyPanel.add(button4);
        
        //Create exit panel at bottom of the window
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new BorderLayout());
        exitPanel.setBounds(0,530,500,30);
        exitPanel.setBackground(new Color(0,0,0,0));
        exitButton = new JButton("Back to Menu");
        exitButton.setBounds(400,0,100,30);
        exitButton.setHorizontalAlignment(JButton.RIGHT);
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitPanel.add(exitButton, BorderLayout.EAST);
        
        //Add panels to Jframe
        this.add(titlePanel);
        this.add(bodyPanel);
        this.add(exitPanel);
        
        //Set size and visibility
        this.setSize(500,560);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    /*
    Handles button click events in the InvestmentScreen interface
    Pre-Condition:
    - The InvestmentScreen must be properly initialized with all buttons
    - All button action listeners must be properly registered
    - Required classes (AddStock, AddBond, AddCrypto, AddGic, WelcomeScreen) must be available
    Post-Condition:
        - For exitButton: Closes the current screen and returns to the WelcomeScreen
        - For button1: Opens the AddStock screen for stock investment creation
        - For button2: Opens the AddBond screen for bond investment creation
        - For button3: Opens the AddCrypto screen for cryptocurrency investment creation
        - For button4: Opens the AddGic screen for GIC investment creation
        - All actions dispose of the current InvestmentScreen window
    Parameters:
        - ActionEvent e: The event object containing information about the button click
    Return:
        -void: No return value
    */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //If button equals to exit button
        if (e.getSource() == exitButton) 
        {
            this.dispose(); //Close current window
            new WelcomeScreen(); //Open welcome screen
        } 
        
        //If button equals add stock button
        else if (e.getSource() == button1) 
        {
            this.dispose(); //Close current window
            new AddStock(); //Open stock screen
        }
        
        //If button equals add bond button
        else if (e.getSource() == button2) 
        {
            this.dispose(); //Close current window
            new AddBond(); //Open bond screen
        }
        
        //If button equals add crypto button
        else if (e.getSource() == button3) 
        {
            this.dispose(); //Close current window
            new AddCrypto();//Open crypto screen
        }
        
        //If button equals add GIC button
        else if (e.getSource() == button4) 
        {
            this.dispose(); //Close current window
            new AddGic();//Open GIC screen
        }
        
    }
    
}