/**
 * Write a description of class Algorithms here. [Coming soon]
 * 
 * @author (Otakar Andrysek) 
 * @version (1.0.0)
 * @date (11/16/2016)
 * 
 */
public class Algorithms
{
    public static void main()
    {   
        // Create an array that contains ten songs
        // Each song will have a name and a rating
        Song[ ] songs = {
            new Song("THE TWIST", 4),
            new Song("SMOOTH", 7),
            new Song("MACK THE KNIFE", 5),
            new Song("HOW DO I LIVE", 10),
            new Song("PARTY ROCK ANTHEM", 1),
            new Song("I GOTTA FEELING", 4),
            new Song("MACARENA (BAYSIDE BOYS MIX)", 8),
            new Song("PHYSICAL", 5),
            new Song("YOU LIGHT UP MY LIFE", 3),
            new Song("HEY JUDE", 9)
        };
        
        // Call other methods
        printSongs(songs);
        int bestSongValue = bestSong(songs);
        int worstSongValue = worstSong(songs, bestSongValue);

    }
    public static int printSongs(Song[] songs)
    {
        // List all songs in the array
        for (int i = 0; i < songs.length; i++)
        {
            System.out.println("Song " + i + " | Name: " + songs[i].getTitle() + " | Rating " + songs[i].getRating());
        }
        return 0;
    }
    
    public static int bestSong(Song[] songs)
    {
        int bestSong = -1;
        int position = -1;
        for (int i = 0; i < songs.length; i++)
        {
            if (songs[i].getRating() > bestSong)
            {
                bestSong = songs[i].getRating();
                position = i;
            }
        }
        System.out.println("\nThe best song is");
        System.out.println("Name: " + songs[position].getTitle() + " | Rating " + songs[position].getRating());
        return songs[position].getRating();
    }
    
    public static int worstSong(Song[] songs, int bestSongValue)
    {
        int worstSong = bestSongValue;
        int position = -1;
        for (int i = 0; i < songs.length; i++)
        {
            if (songs[i].getRating() < worstSong)
            {
                worstSong = songs[i].getRating();
                position = i;
            }
        }
        System.out.println("\nThe worst song is");
        System.out.println("Name: " + songs[position].getTitle() + " | Rating " + songs[position].getRating());
        return songs[position].getRating();
    }
}