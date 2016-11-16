
/**
 * An array version of medialib.
 * 
 * @author (Otakar Andrysek) 
 * @version (5.0)
 * @date (10/25/16)
 */
public class ArrayMediaLib
{
    public static void main()
    {
        /**
         * Part V
        */
        
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
        
        /**
         * Part IV
        */
        
        // Top ten billboard songs in one array
        Song[ ] topTenSongs = {
            new Song("THE TWIST"),
            new Song("SMOOTH"),
            new Song("MACK THE KNIFE"),
            new Song("HOW DO I LIVE"),
            new Song("PARTY ROCK ANTHEM"),
            new Song("I GOTTA FEELING"),
            new Song("MACARENA (BAYSIDE BOYS MIX)"),
            new Song("PHYSICAL"),
            new Song("YOU LIGHT UP MY LIFE"),
            new Song("HEY JUDE")
        };
        
        // Print the top songs
        for (Song s: topTenSongs)
        {
            System.out.println(s.getTitle());
        }
        
        /**
         * Added for 1.2.3 Part II 
        */
        int index = SongFinder.findTitle(topTenSongs, "SMOOTH");
        if (index >=0 ) 
        {
            System.out.println("Found " + topTenSongs[index].getTitle());
        }
        else  
        {
            System.out.println("Song not found!");
        }
    }
}