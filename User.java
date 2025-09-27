//This user class handles the all the attributes and printing/updating functions about the user. 
public class User
{
    //Declare instances
    private String userName;
    private int age;
    private String occupation;
    private int totalInvestments;
    
    //Constructor for creating completely a  new user
    public User(String userName, int age, String occupation)
    {
        this.userName = userName;
        this.age = age;
        this.occupation = occupation;
        this.totalInvestments = 0;
        HandlingFiles.saveNewUser(this);
    }
    
    //Uses method overlaoding, this is used when a user is already created
    public User(String userName, int age, String occupation, int totalInvestments)
    {
        this.userName = userName;
        this.age = age;
        this.occupation = occupation;
        this.totalInvestments = totalInvestments;
    }
    
    //Getters
    public String getUserName() 
    {
        return userName;
    }
    
    public int getAge() 
    {
        return age;
    }
    
    public String getOccupation() 
    {
        return occupation;
    }
    
    public int getTotalInvestments() 
    {
        return totalInvestments;
    }
    
    
    /*
    This updateProfile method updates the user's profile with the given inputs.
    Pre-Condition:
        -The userName and occupation must be non-empty and valid
        -The age must be a valid integer
        -The total investements must be a valid double
    Post-Condition:
        -The method must correctly update the user's profile with the given inputs.
    Parameters:
        -userName(user's name), age(user's age), occupation(user's occupation), totalInvestments(user's total investment)
    Return:
        -None
    */
    
    public void updateProfile(String userName, int age, String occupation, int totalInvestments)
    {
        //Update the user's profile
        this.userName = userName;
        this.age = age;
        this.occupation = occupation;
        this.totalInvestments = totalInvestments;
    }

    /*
    This printDetails method prints the detailed information of the user.
    Pre-Condition:
        -the attributes of the user must be properly intialized 
    Post-Condition:
        -The method must correctly print out the user's information in a formatted way.
    Parameters:
        -userName(user's name), age(user's age), occupation(user's occupation), totalInvestments(user's total investment)
    Return:
        -None
    */
    
    @Override
    public String toString()
    {
        return "true\nUsername\n" + userName + "\nAge\n" + age + "\nOccupation\n" + occupation + "\nTotal Investments\n"+totalInvestments;
    }
}