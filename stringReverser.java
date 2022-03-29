/**
* This code reverses a bunch of string from
*
* @author  Liam Csiffary
* @version 1.0.1
* @since   2022-03-29
*/

// import necessary modules
import java.io.File;
import java.util.List;
import java.util.Scanner; 


// class
public class stringReverser {

  // generates the array of inputs from a text file
  public static String[] ArrayGenerator(File file) throws Exception {

    // defining vars
    List<String> originalListString = new ArrayList<String>();
    System.out.println(file);
    Scanner scStudent = new Scanner(file);

    // pass the path to the file as a parameter
    while (scStudent.hasNextLine()) {
      originalListString.add(scStudent.nextLine());
    }

    // for testing purposes
    System.out.println(originalListString);

    // create array of length
    String[] array = new String[originalListString.size()];

    // fill the array
    for (int i = 0; i < array.length; i++) {
      array[i] = originalListString.get(i);
    }

    return array;
  }

  // reverses the string
  public static String reverser(String originalString) {

    // whilst the oString is not empty keep reruning the function
    // I like to put it on top because it is the most common outcome
    if (!originalString.equals("")) {
      // takes the remaining string save the first char and sends it back to the File
      // saves the first letter for when we reconstruct after the string has been exhausted
      return reverser(originalString.substring(0 + 1)) + originalString.substring(0, 1);

    } else  {
      // once we've exhausted the string
      return originalString;

    }
  }


  public static void main(String[] args) throws Exception {

    // creates the file object
    File file = new File(
        "C:/Users/s299776/ICS4U/Unit2/Java/Unit2-01-Java/testCases.txt");

    // gets the array of testCases from the ArrayGenerator
    String[] testCases = ArrayGenerator(file);

    // goes to next line for beautifying reasons
    System.out.println("\n");

    // prints the normal string and the reversed string for each index
    // of the array, also sends it down an extra line so it's easier to read
    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Original string: " + testCases[i]);
      System.out.println("Reversed string: " + reverser(testCases[i]) + "\n");
    }
  }
}
