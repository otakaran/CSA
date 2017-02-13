/**
 * A collection 
 * 
 * @author (Otakar Andrysek) 
 * @version (2.0.0)
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
            new Song("MACARENA (BAYSIDE BOYS MIX)", 9),
            new Song("PHYSICAL", 5),
            new Song("YOU LIGHT UP MY LIFE", 3),
            new Song("HEY JUDE", 9)
        };
        
        // Call other methods
        //printSongs(songs);
        int bestSongValue = bestSong(songs);
        //int worstSongValue = worstSong(songs, bestSongValue);
        tiedForSecond(songs, bestSongValue);
        
        //deleteSong(songs, "SMOOTH");
    }
    
    public static int printSongs(Song[] songs)
    {
        // List all songs in the array
        for (int i = 0; i < songs.length; i++)
        {
            System.out.println("Song " + (i+1) + " | Name: " + songs[i].getTitle() + " | Rating " + songs[i].getRating());
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
    
    public static void tiedForSecond(Song[] songs, int topSong)
    {
        topSong = songs[0].getRating();
        int secondSong = (topSong * 10);
        for (Song i : songs)
        {
            if (i.getRating() < topSong)
            {
                topSong = i.getRating();
            }
        }
        for (Song i : songs)
        {
            if (i.getRating() < secondSong && i.getRating() > topSong) 
            {
                secondSong = i.getRating();
            }  
        }
        for (Song i : songs)
        {
            if (i.getRating() == secondSong)
            {
                System.out.println("Second best song(s)" + i.getTitle());
            }
        }
    }
    
    public static int deleteSong(Song[] songs, String songToDelete)
    {
        int position = -1;
        String storedTitle = "ERROR";
        for (int i = 0; i < songs.length; i++)
        {
            System.out.println("i = " + i);
            storedTitle = songs[i].getTitle();
            System.out.println(storedTitle);
            if (storedTitle.equals(songToDelete) || i > position && songs.length > i)
            {
                System.out.println("YO");
                if (i == 9)
                {
                    System.out.println("HAHA");
                    songs[8] = null;
                    return 1;
                }
                System.out.println("ERR");
                position = i;
                songs[i] = songs[i + 1];
            }
        }
        printSongs(songs);
        return 1;
    }
}