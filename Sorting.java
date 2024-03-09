// File: Sorting.java
// Name: Rachel F. Shindelus
// Due: March 15th, 2024
// Class: CSC 130 - Section 03
/* Purpose: Have an array of at least 20 integers that will have a function 
   using linear search algorithm to locate one of its values. The next search 
   will be conducted using binary search algorithm. The last functiion should 
   call the selection sort algorithm to sort the values in the array. 
*/
import java.util.*;
import java.util.Scanner;     // scanner class for user input

public class Sorting 
{
   static final int ARRAY_SIZE = 20;      // array size of at least 20 integers
   
   // Function to generate random numbers to populate an array
   public static int[] generateRandomNumber(int[] array)
   {
      int randomNumber;
      for(int i = 0; i < ARRAY_SIZE; i++)
      {
         randomNumber = (int)(Math.random() * 100);  // generates a random number 0-99
         array[i] = randomNumber;
      }  // END for loop
      return array;      // returns the filled array
   }  // END generateRandomNumber()

   // function to print contents of an array
   public static void printArray(int[] array)
   {              
      for(int i = 0; i < ARRAY_SIZE; i ++)
      {
         System.out.print(array[i] + "  ");
         // This will only let max of 10 integers be printed on each line
         if(((i + 1) % 10) == 0)    
         {
            System.out.println(" ");
         }
      }      
   }
   
   // function using linear search algorithm to locate a specific number (the key)
   public static void linearSearch(int[] array, int key)
   {
      System.out.println("_____LINEAR SEARCH ALGORITHM_____");
      int numOfComparisons = 0;
      boolean foundValue = false;         // set to false before dunction begins the search forr the key value
      for (int i = 0; i < ARRAY_SIZE; i++)
      {
         numOfComparisons++;
         if (array[i] == key)
         {
            System.out.println("Value [" + key + "] located at element " + i);
            System.out.println("Comparisons made: " + numOfComparisons);
            System.out.println("\nThe Big-O notation for this search algortithm is " 
                             + "\nO(n) as the function is dependent on the value of n. "
                             + "\nThe execution is dependent on the values location "
                             + "\nin the elements of the array. \n");
            foundValue = true;            // found the value within the array
            break;                        // break out of the loop sunce value was found
         }
      }  // END for loop
      if(!foundValue)   // Do this if the value was not found in the array
      {
         System.out.println("Value was not found in this array.");
         printArray(array);
         System.out.println("Choose a new value to find in the array: ");
         Scanner myObj = new Scanner(System.in);
         key = myObj.nextInt();
         linearSearch(array, key);     // call back to start of function
      }
      
   }  // END linearSearch() function
   
   // function uses binary search algorithm to locate a value in the array. 
   // binary searching splits the searcheable list in half after each iteration.
   public static void binarySearch(int[] array, int key)
   {
      System.out.println("_____BINARY SEARCH ALGORITHM_____");
      int numOfComparisons = 0;
      boolean foundValue = false;         // set to false before dunction begins the search forr the key value
      int headLocation = 0;
      int tailLocation = ARRAY_SIZE - 1;
      int middlePointer;
      while(headLocation <= tailLocation)
      {         
         middlePointer = (tailLocation + headLocation) / 2;
         numOfComparisons++;
         if(array[middlePointer] == key)
         {
            System.out.println("Value [" + key + "] located at element " + middlePointer);
            System.out.println("Comparisons made: " + numOfComparisons);
            foundValue = true;
            break;
         }  // END if
         else if (array[middlePointer] < key)
         {
            headLocation = middlePointer + 1;
         }  // END else if
         else 
         {
            tailLocation = middlePointer - 1;
         }  // END ELSE IF         
      }  // END while loop
      System.out.println("\nThis algorithm seems to most often have a time complexity "
                       + "\nof O(log n). This is because this algorithm continuously "
                       + "\nsplits the length of elements in the algorithm in half until "
                       + "\nthe desired element is found. Its worst case would be O(n) "
                       + "\nas it would have to navigate through every single element if "
                       + "\nif the desired value was not found until the very last iteration.\n");
      if(!foundValue)
         {
            System.out.println("Value was not found in this array.");
         }
   }  // END binarySearch function   
   
   // this selection sort function will be used to sort the array in ascending order
   public static void selectionSort(int[] array)
   {
      int numOfComparisons = 0;
      System.out.println("____SELECTION SORT ALGORITHM____");
      for (int i = 0; i < (ARRAY_SIZE - 1); i++)
      {
         numOfComparisons++;
         int indexOfSmallestEllement = i;
         for(int j = i + 1; j < ARRAY_SIZE; j++)
         {
            if(array[j] < array[indexOfSmallestEllement])
            {
               indexOfSmallestEllement = j;
            }  // END if
         }  // END inner for loop
         if(indexOfSmallestEllement != i)
         {
            int temp = array[i];
            array[i] = array[indexOfSmallestEllement];
            array[indexOfSmallestEllement] = temp;
         }  // END if
      }  // END for loop
      System.out.println("\tSorted Array: ");
      printArray(array);
      System.out.println("Number of comparisons made: " + numOfComparisons);
      System.out.println("\nThe Big-O notation for this algorithm is O(n^2). "
                       + "\nThe algorithm requires a for loop embedded in another"
                       + "\nfor loop. Thus the time complexity would be n x n. \n");
   }  // END selectionSort function

   public static void main(String[]args)
   {
      int numArray[];                     // declare the array
      numArray = new int[ARRAY_SIZE];     // initialize array of size ARRAY_SIZE. values set to 0
      generateRandomNumber(numArray);     // call function to populate numArray w/ random #s
      printArray(numArray);               // call function to print contents of array
      System.out.print("Enter a value within the array to be searched for: ");
      Scanner myObj = new Scanner(System.in);
      int searchingValue = myObj.nextInt();      
      linearSearch(numArray, searchingValue);
      selectionSort(numArray);      
      binarySearch(numArray, searchingValue);
      
   }  // END main
}  // END Sorting class