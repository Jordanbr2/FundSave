//This Investments class is the parent class of all the assets such as stocks, bonds, GIC, and crypto. 
//It contains the attributes that are essential for investment and the methods to calculate the metrics of the asset.
public abstract class Investments 
{
    //Declare the attributes
    //Stock = 0, Bond = 1, Crypto = 2, GIC = 3,
    protected int type;
    protected String name;
    protected String symbol;
    protected String riskLevel;
    protected double price;
    protected double expectedReturn;
    protected double riskFreeRate;
    protected double std;
    
    //Constructor for subclasses
    public Investments(int type, String name, String symbol, String riskLevel, double price, double expectedReturn, double riskFreeRate, double std)
    {
        this.type = type;
        this.name = name;
        this.symbol = symbol;
        this.riskLevel = riskLevel;
        this.price = price;
        this.expectedReturn = expectedReturn;
        this.riskFreeRate = riskFreeRate;
        this.std = std;
    }
    
    /*
    This calculateSharpRatio method calculates the sharp ratio of the stock.
    Pre-Condition:
        -The expected return, risk free rate, and standard deviation must be initialized
        -The std must not be zero to avoid division by zero error.
    Post-Condition:
        -The method must return a valid sharp ratio of the asset.
    Parameters:
        -None
    Return:
        -a valid double sharp ratio of the asset.
    */
    
    public double calculateSharpRatio()
    {
        //Sharp Ratio = (Expected Return - Risk Free Rate)/ standard deviation
        double sharpRatio = (expectedReturn - riskFreeRate)/std;
        
        //Return the sharp ratio
        return sharpRatio;
    }
    
    /*
    This calculateRiskLevel method returns the risk level of the asset.
    Pre-Condition:
        -A valid risk level must be initialized
    Post-Condition:
        -The method must return a valid risk level(low, medium, high)
    Parameters:
        -None
    Return:
        -a valid risk level as a string.
    */
    
    public String calculateRiskLevel()
    {
        return riskLevel;
    }
    
    //Abstract method for displaying info about the asset
    public abstract String toString();
}