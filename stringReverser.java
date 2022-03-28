import java.util.Scanner; 

public class stringReverser {


  public static String reverser(String originalString) {

    if (!originalString.equals("")) {
      return reverser(originalString.substring(0 + 1)) + originalString.substring(0, 1);

    } else  {
      System.out.println("Finished");
      return originalString;
      
    }
  }


  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("This is the string reverser program!");
    System.out.println("Please inut a string to be reversed: ");
    String userString = scanner.nextLine();

    String reversedString = reverser(userString);
    System.out.println("end");
    System.out.println(reversedString);

  }
}
