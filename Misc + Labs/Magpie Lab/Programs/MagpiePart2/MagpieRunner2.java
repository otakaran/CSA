// Import user input library
import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * *ORIGNIAL*
 * @author Laurie White
 * @version April 2012
 * 
   *UPDATED*
 * @author Otakar Andrysek
 * @version .1
 * @date 10/2/16
 */

public class MagpieRunner2
{
    //Create a Magpie, give it user input, and print its replies.
    public static void main(String[] args)
    {
        Magpie2 maggie = new Magpie2();
        
        System.out.println (maggie.getGreeting());  // Greet the user
        Scanner in = new Scanner (System.in);   // Scan for user input
        String statement = in.nextLine();   // Keep it going
        
        // If the user enters bye exit out of the program
        while (!statement.equals("Bye"))
        {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
    }
}
