//This Crypto class is a subclass of its parent class Investments. It has unique attributes and methods specific to the crypto asset.
public class Crypto extends Investments
{
    //Initialize the instances
    private String blockChain;
    private String category;
    
    //Constructor, and calls constructor from parent class as well
    public Crypto(String blockChain, String category, String name, String symbol, String riskLevel, 
                  double price, double expectedReturn, double riskFreeRate, double std)
    {
        super(2, name, symbol, riskLevel, price, expectedReturn, riskFreeRate, std);
        this.blockChain = blockChain;
        this.category = category;
    }
    

    //toString method specific to this subclass
    @Override
    public String toString()
    {
        return "\n" + "Name: " + name + ". Symbol: " + symbol + ". Risk Level: " + riskLevel + ". Price: " + price + ". Expected Return: " + expectedReturn + ". Risk-free Rate: " + riskFreeRate + ". Standard Deviation: " + std + ". Blockchain: " + blockChain + ". Category" + category; //Idk how you gonna format it with swing
    }
    
    /*
    This isStableCoin method indicates if the coin is stable or not.
    Pre-Condition:
        -The cateogory of the coin must be valid
    Post-Condition:
        -The method must return a boolean value indicating whether the coin is a stable coin or not.
    Parameters:
        -None
    Return:
        -a boolean value indicating whether the coin is a stable coin or not.
    */
    
    public boolean isStableCoin()
    {
        return category.equalsIgnoreCase("stablecoin");
    }
}