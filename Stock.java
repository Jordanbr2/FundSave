//This Stock class is a subclass of its parent class Investments. It has unique attributes and methods specific to the Stock asset.
class Stock extends Investments
{
    //Initialize the instances
    private long CUSIP;
    private String sector;
    
    //Constructor, and calls constructor from parent class as well
    public Stock (long CUSIP, String sector, String name, String symbol, String riskLevel, double price, double expectedReturn, double riskFreeRate, double std)
    {
        super(0, name, symbol, riskLevel, price, expectedReturn, riskFreeRate, std);
        this.CUSIP = CUSIP;
        this.sector = sector;
    }
    

    /*
     This toString returns a formatted string representation of the Stock object
     Pre-Condition:
        - All instance variables must be properly initialized
        - The parent class Investments must have valid values for all attributes
     Post-Condition:
        - Returns a comprehensive string containing all stock information
        - Maintains the original data integrity of all attributes
        - Format includes all relevant stock details in a readable manner
     Parameters:
        - None
     Return:
        - String: A formatted string containing all stock information
    */
    
    @Override
    public String toString()
    {
        return "\n" +  "Name: " + name + "Symbol: " + symbol + "Risk Level: " + riskLevel + "Price: " + price + "Expected Return: " + expectedReturn + "Risk-free Rate: " + riskFreeRate + "Standard Deviation: " + std + "CUSIP: " + CUSIP + "Sector: " + sector; //Idk how you gonna format it with swing
    }
}