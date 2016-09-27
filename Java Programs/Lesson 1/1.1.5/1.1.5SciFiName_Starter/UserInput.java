// Import a library that allows for user input, finally!
import java.util.Scanner;

/**
 * Convenience class for getting input from a user.
 */

public class UserInput   
{
    public static String getString() {
      Scanner in = new Scanner(System.in);  // Scans for user input
      return in.next(); // Retuns input to caller function
   }
}