// import necessary modules
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* This code reverses a bunch of string from.
*
* @author  Liam Csiffary
* @version 1.1
* @since   2022-03-29
*/

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


  // also from https://www.w3schools.com/java/java_files_create.asp
  public static void Writer(String[] arr) {
    try {
      // creates file writing object
      FileWriter myWriter = new FileWriter("reversed.txt");

      // my code
      // just writes to the file the same way you'd print it to the terminal
      // except with myWriter.write instead of System.out.print()
      for (int each = 0; each < arr.length; each++) {
        myWriter.write(arr[each] + "\n");
      }

      // closes the file
      myWriter.close();
      System.out.println("Successfully wrote to the file.");

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
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


  // main function, calls the other functions and prints the normal and reversed strings
  public static void main(String[] args) throws Exception {

    // creates the file object
    File file = new File(
        "C:/Users/s299776/ICS4U/Unit2/Java/Unit2-01-Java/testCases.txt");

    // gets the array of testCases from the ArrayGenerator
    String[] testCases = ArrayGenerator(file);

    // goes to next line for beautifying reasons
    System.out.println("\n");

    // an array to be passed to the txt file creator
    String[] txtArray = new String[testCases.length];

    // prints the normal string and the reversed string for each index
    // of the array, also sends it down an extra line so it's easier to read
    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Original string: " + testCases[i]);
      String reversedString = ("Reversed string: " + reverser(testCases[i]) + "\n");
      System.out.println(reversedString);
      txtArray[i] = reversedString;
    }
    Writer(txtArray);
  }
}
