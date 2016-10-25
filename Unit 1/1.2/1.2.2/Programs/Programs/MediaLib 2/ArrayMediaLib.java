
/**
 * Write a description of class ArrayMediaLib here.
 * 
 * @author (Otakar Andrysek) 
 * @version (1.0)
 * @date (10/25/16)
 */
public class ArrayMediaLib
{
    public static void main()
    {
        // Create an array of five strings. (initalization list)
        String[ ] sharingFriends = {
            new String("Tamir"),
            new String("Dane"),
            //new String("Vikas"),
            new String("Andrew"),
            new String("Stan") 
        };
       
        // Iterate over my friends' array
        for (int i = 0; i < sharingFriends.length; i++)     // i < length of array
        {
            System.out.println(sharingFriends[i]);  // Print elements in order
        }
        
        /**
         * Part III
        */
       
        // Days between purchase
        int[ ] daysBetweenPurchase = {2, 5, 1, 2, 4, 2, 1, 3};
        int sumDays = 0;
        
        // Calculate mean purchase time
        for (int j = 0; j < daysBetweenPurchase.length; j++)     // i < length of array
        {
            sumDays += daysBetweenPurchase[j];
        }
        float meanDays = sumDays / daysBetweenPurchase.length;
        System.out.println(meanDays);  // Print elements in order
    }
}