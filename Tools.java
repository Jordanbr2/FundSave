//This class is unused because of the rapid availability of the list to the user removes the need for searching and sorting, therefore, we decided not to use it.
//You might see this is copy and paste, but we have written this ourselves in the unit 3 assignment
public class Tools {
    /*
    This quickSort method uses method overlaoding to pass in the low and high indexes
    
    Pre-Condition:
        -A valid array must be passed in
        
    Post-condition:
        -The method must call the other quick sort method and pass in the low and high indexes
    
    Parameters: 
        -numArray(the array needed to be sorted), ascendOrDescend(true equals ascend, false equals descend)
    
    Return:
        -None
    
    
    //Use method overloading to avoid the need for main method to pass in lowIndex and highIndex everytime quickSort is called    
    public static void quickSort(int[] numArray, boolean ascendOrDescend)
    {
        //Call quickSort and pass in the parameters including lowIndex and highIndex
        quickSort(numArray, 0, numArray.length-1, ascendOrDescend);
    }
    
    
    This quickSort method uses the quick sort sorting routine to sort out the array in a ascending or descending order depending on the parameters passed in. 
    
    Pre-Condition:
        -A valid array must be passed in
        -A valid low and high index must be passed in
        -A valid boolean must be passed in 
        
    Post-condition:
        -The method must sort the array in an ascending or descending order depending on the parameters passed in.
    
    Parameters: 
        -numArray(the array needed to be sorted), lowIndex(the first element's index of the array), highIndex(the last element's index of the array), ascendOrDescend(true equals ascend, false equals descend)
    
    Return:
        -None
    
    
    public static void quickSort(int[] numArray, int lowIndex, int highIndex, boolean ascendOrDescend)
    {
        //If the lowIndex and highIndex is the same, there is only one element needed to be sorted, therefore, return
        if(lowIndex>=highIndex)
        {
            return;    
        }
        
        //Create random object
        Random random = new Random();
        
        //Pick a random index to partition first and switch it with the last element to improve runtime
        //It will generate an index between the range of highIndex and lowIndex
        //lowIndex+1 because .nextInt excludes high index
        int pivotIndex = random.nextInt(highIndex-lowIndex+1) + lowIndex;
        
        //Store pivot value to pass in later
        int pivotValue = numArray[pivotIndex];
        
        //Swap the random number with the last element in the array or subarray
        Swap.swap(numArray,pivotIndex,highIndex);
        
        //Call partition method to partition and also store where the pivot ended up for recursion later
        int leftPointer = partition(numArray, lowIndex, highIndex, pivotValue, ascendOrDescend);
        
        //Use recursion to partition the subgroups
        
        //Group on the left
        //Left pointer -1 because that is the number on the left of the pivot
        quickSort(numArray, lowIndex, leftPointer - 1, ascendOrDescend);
        
        //Group on the right
        //Left pointer +1 because that is the number on the right of the pivot
        quickSort(numArray, leftPointer + 1, highIndex, ascendOrDescend);
        
    }
    
    This partition method aims to partition the groups using left pointers and right pointers.
    
    Pre-Condition:
        -A valid array must be passed in
        -A valid low and high index must be passed in
        -A valid boolean must be passed in 
        
    Post-condition:
        -The method must successfully partition the group and return the left pointer
    
    Parameters: 
        -numArray(the array needed to be sorted), lowIndex(the first element's index of the array), highIndex(the last element's index of the array), ascendOrDescend(true equals ascend, false equals descend)
    
    Return:
        -the left pointer
    
    public static int partition(int[] numArray, int lowIndex, int highIndex, int pivotValue, boolean ascendOrDescend)
    {
        //Store the lowIndex and highIndexes in left and right pointers
        int leftPointer = lowIndex;
        
        //Shift left to start at the value on the left of the pivot
        int rightPointer = highIndex-1;
        
        //Prevent leftPointer from crossing rightPointer and also loop multiple swaps until the two pointers meet
        while(leftPointer<rightPointer)
        {
            
            //Move leftPointer right 
            //Check if ascending or descending order
            while((ascendOrDescend ? numArray[leftPointer]<=pivotValue : numArray[leftPointer]>=pivotValue) && leftPointer < rightPointer)
            {
                leftPointer++;
            }
            
            //Move rightPointer left
            //Check if ascending or descending order
            while((ascendOrDescend ? numArray[rightPointer]>=pivotValue : numArray[rightPointer]<=pivotValue)  && leftPointer < rightPointer)
            {
                rightPointer--;
            }
            
            //Swap the two values in the two pointers
            Swap.swap(numArray,leftPointer,rightPointer);
            
        }
        
        //If the value at left pointer is greater than the pivot, swap the two 
        if(ascendOrDescend ? numArray[leftPointer] > pivotValue : numArray[leftPointer] < pivotValue)
        {
            Swap.swap(numArray, leftPointer, highIndex);
        }
        
        //However, if it is not, leave the pivot alone, and set leftPointer to highIndex because it is where the pivot lies
        //The recursive calls in the quickSort will still have to use the leftPointer for further partitioning
        else
        {
            leftPointer = highIndex;
        }
        
        //Return leftPointer for later recursion 
        return leftPointer; 
        
    }

    This swap method swaps two elements in the array at the specified indexes.
    Pre-Condition:
        -A valid array must be passed in
        -A valid first index must be passed in
        -A valid second index must be passed in
        
    Post-condition:
        -The method must swap the two elements in the array at the specified indexes.
    
    Parameters: 
        -numArray(the array containing the elements to be swapped), a(index of the first element), b(index of the second element)
    
    Return:
        -None
    
    public static void swap(int[] numArray, int a, int b)
    {
        int tempVar = numArray[a];
        numArray[a] = numArray[b];
        numArray[b] = tempVar;
    }
    
    public static void linearSearch (int[] arr, int value) 
    {
        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i]==value)
            {
                return i;
            }
        }
        return -1;
    }
    */
}