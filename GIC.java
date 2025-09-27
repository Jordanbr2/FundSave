//This GIC class is a subclass of its parent class Investments. It has unique attributes and methods specific to the GIC asset.
class GIC extends Investments
{
    //Initialize the instances
    private double interestRate;
    
    //Whether if you can take out the money early
    private boolean locked;
    
    //Constructor, and calls constructor from parent class as well
    public GIC (boolean locked, double interestRate, String name, String symbol, String riskLevel, 
                  double price, double expectedReturn, double riskFreeRate, double std)
    {
        super(3, name, symbol, riskLevel, price, expectedReturn, riskFreeRate, std);
        this.interestRate = interestRate;
        this.locked = locked;
    }
    
    /*
    Returns a formatted string representation of the GIC object
    Pre-Condition:
        - All instance variables must be properly initialized
        - The parent class Investments must have valid values for all attributes
    Post-Condition:
        - Returns a comprehensive string containing all GIC information
        - Maintains the original data integrity of all attributes
        - Format includes all relevant GIC details in a readable manner
    Parameters:
        - None
    Return:
        - String: A formatted string containing all GIC information
    */
    @Override
    public String toString()
    {
        return "\n" + "Name: " + name + ". Symbol: " + symbol + ". Risk Level: " + riskLevel + ". Price: " + price + ". Expected Return: " + expectedReturn + ". Risk-free Rate: " + riskFreeRate + ". Standard Deviation: " + std + ". Interest Rate: " + interestRate + ". Locked status: " + locked; //Idk how you gonna format it with swing
    }
}