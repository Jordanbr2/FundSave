//This Bond class is a subclass of its parent class Investments. It has unique attributes and methods specific to the Bond asset.
class Bond extends Investments 
{
    //Initialize the instances
    private long CUSIP;
    private String issuer;
    private double interestRate;
    
    //Constructor, and calls constructor from parent class as well
    public Bond (long CUSIP, String issuer, double interestRate, String name, String symbol, String riskLevel, 
                  double price, double expectedReturn, double riskFreeRate, double std)
    {
        super(1, name, symbol, riskLevel, price, expectedReturn, riskFreeRate, std);
        this.CUSIP = CUSIP;
        this.issuer = issuer;
        this.interestRate = interestRate;
    }
    
    
    //toString method specific to this subclass
    @Override
    public String toString()
    {
        return "\n" + "Name: " + name + ". Symbol: " + symbol + ". Risk Level: " + riskLevel + ". Price: " + price + ". Expected Return: " + expectedReturn + ". Risk-free Rate: " + riskFreeRate + ". Standard Deviation: " + std + ". CUSIP: " + CUSIP + ". Issuer: " + issuer + ". Interest Rate: " + interestRate; //Idk how you gonna format it with swing
    }
    
    /*
    This isGovBond method returns if the coin is stable or not.
    Pre-Condition:
        -The issuer of the coin must be valid
    Post-Condition:
        -The method must return a boolean value indicating whether the GIC is issued by the government.
    Parameters:
        -None
    Return:
        -a boolean value indicating whether the GIC is issued by the government.
    */
    
    public boolean isGovBond()
    {
        return issuer.equalsIgnoreCase("Government");
    }    
}