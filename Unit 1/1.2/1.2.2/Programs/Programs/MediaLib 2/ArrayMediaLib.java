
/**
 * Write a description of class ArrayMediaLib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayMediaLib
{
    public static void main()
    {
        // Create an array of five strings. (initalization list)
        String[ ] sharingFriends = {
            new String("Tamir"),
            new String("Dane"),
            new String("Vikas"),
            new String("Andrew"),
            new String("Stan") 
        
        };
        
        // Iterate over my friends' array
        for (int i = 0; i < 5; i++)
        {
            System.out.println(sharingFriends[i]);  // Print elements in order
        }
    }
}