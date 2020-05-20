package checkifequall;

import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here

class Main {

  // Add any helper functions you may need here
  
  boolean compare(int[] array_a, int[] array_b) 
  {
     for(int i = 0; i < array_a.length; i++)
     {
        if ( array_a[i] != array_b[i])
           return false;
     }
    return true;
  }
  
  int [] getReversedSubArray(int[] array_b , int i, int j)
  {
     int[] ret = new int[array_b.length];
     for(int k = 0; k < i ; k++ )
     {
        ret[k] = array_b[k];
     }
     for( int k = j; k>=i; k--)
     {
        ret[ i + j - k ]= array_b[k];
     }
     for( int k = j+1; k < array_b.length; k++)
     {
        ret[k]= array_b[k];
     }
    
    return ret;
    
  }
  

  boolean areTheyEqual(int[] array_a, int[] array_b) {
    // Write your code here
    for( int i = 0; i < array_a.length; i++ ) 
    {
       for(int j = i+1; j < array_a.length; j++)
       {
           int [] rev = getReversedSubArray (array_b, i,j);
           if(compare(array_a, rev) )
              return true;
         
       }
    }
   
    return false;
  }




  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected); 
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[" + str + "]");
  }
  
  public void run() {
    int[] array_a_1 = {1, 2, 3, 4};
    int[] array_b_1 = {1, 4, 3, 2};
    boolean expected_1 = true;
    boolean output_1 = areTheyEqual(array_a_1, array_b_1); 
    check(expected_1, output_1); 

    int[] array_a_2 = {1, 2, 3, 4};
    int[] array_b_2 = {1, 4, 3, 3};
    boolean expected_2 = false;
    boolean output_2 = areTheyEqual(array_a_2, array_b_2); 
    check(expected_2, output_2); 
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}