/**
 * SciFiName gathers input from a user to generate a custom name that
 * sounds like it could be used in a science fiction book or movie.
 * 
 * @author Otakar Andrysek
 * @version .1
 * @date 9/26/2016
 */

public class SciFiName   
{
    /**
     * All input that you privide should be at least three letters long
     * or the program may crash (but feel free to test this!)
     * 
     * For best results, user lowercase letters and do not use spaces in your input
     */
    
    public static void main()
    {
        // Print user welcome
        System.out.println("If you provide me some information I will provide a Science Fiction name for you.");
        System.out.println("Please have all responses  be at least three characters long.");
        //System.out.println("For best results, user lowercase letters with no spaces.\n");

        // Notice this method (print) does not print a newline
        System.out.print("Enter your first name: ");
        String firstName = UserInput.getString();
        System.out.print("Enter your last name: ");
        String lastName = UserInput.getString();
        System.out.print("Enter the city where you or one of your parents were born: ");
        String city = UserInput.getString();
        System.out.print("Enter the name of your grammar school: ");
        String school = UserInput.getString();
        System.out.print("Enter the first name of a sibling or other relative: ");
        String relativeName1 = UserInput.getString();
        System.out.print("Enter the first name of a second sibling or relative: ");
        String relativeName2 = UserInput.getString();
        
        // Active variables: firstName, lastName, city, school, relativeName1, relativeName2

        // Generate a SciFi Name
        String SciFiName1 = firstName.substring(0,3) + lastName.substring(0,2);
        String SciFiName2 = city.substring(0,2) + school.substring(0,3);
        
        // Generage a SciFi Place
        String SciFiPlace =  relativeName1.substring((int)(Math.random() * ((relativeName1.length() - 1) + 1))) + relativeName2.substring((int)(Math.random() * ((relativeName2.length() - 1) + 1)));
        
        // Preform some formatting
        SciFiName1 = SciFiName1.toLowerCase();
        SciFiName1 = SciFiName1.substring(0, 1).toUpperCase() + SciFiName1.substring(1);
        SciFiName2 = SciFiName2.toLowerCase();
        SciFiName2 = SciFiName2.substring(0, 1).toUpperCase() + SciFiName2.substring(1);
        SciFiPlace = SciFiPlace.toLowerCase();
        SciFiPlace = SciFiPlace.substring(0, 1).toUpperCase() + SciFiPlace.substring(1);
        
        // Print a friendly message
        System.out.printf("Hello %s %s of %s. Welcome!", SciFiName1, SciFiName2, SciFiPlace);
    }
}
