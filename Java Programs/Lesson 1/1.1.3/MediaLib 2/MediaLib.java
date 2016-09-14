/**
 * MediaLib the the wrapper class for the whole program. This program stores various sorts
 * of media (songs, movies, and book) with data about each one. This is an introductory p-
 * rogram to learn about objects and classes in Java.
 * 
 * @author (Otakar Andrysek) 
 * @version (2.1)
 * @date (9/14/2016)
 */
public class MediaLib
{
    public static void main()
    {
        // Welcome user
        System.out.println("Welcome to your Media Library");
        
        // Initialize objects
        // And creating 10 songs
        Song song1 = new Song("Hello",1.29,3);
        Song song2 = new Song("CoolSong",.99,1);
        Song song3 = new Song("Cat",1.29,3);
        Song song4 = new Song("Great",.99,1);
        Song song5 = new Song("Dog",1.29,3);
        Song song6 = new Song("Fire",.99,1);
        Song song7 = new Song("Hamster",1.29,3);
        Song song8 = new Song("Tree",.99,1);
        Song song9 = new Song("Water",1.29,3);
        Song song10 = new Song("Lake",.99,1);
        
        // The other objects
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Book book1 = new Book();
        Book book2 = new Book();
        
        // Print my collection
        System.out.println("Below are the prints of the object");
        System.out.println(song1);
        System.out.println(song2);
        System.out.println(song3);
        System.out.println(song4);
        System.out.println(song5);
        System.out.println(song6);
        System.out.println(song7);
        System.out.println(song8);
        System.out.println(song9);
        System.out.println(song10);
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println();
        
        // Print Out ALL the songs
        // SONG 1
        System.out.println("Below is song1 info:");
        System.out.println(song1.getTitle());
        System.out.println(song1.getRating());
        System.out.println(song1.getPrice());
        System.out.println();
        // SONG 2
        System.out.println("Below is song2 info:");
        System.out.println(song2.getTitle());
        System.out.println(song2.getRating());
        System.out.println(song2.getPrice());
        System.out.println();
        // SONG 3
        System.out.println("Below is song3 info:");
        System.out.println(song3.getTitle());
        System.out.println(song3.getRating());
        System.out.println(song3.getPrice());
        System.out.println();
        // SONG 4
        System.out.println("Below is song4 info:");
        System.out.println(song4.getTitle());
        System.out.println(song4.getRating());
        System.out.println(song4.getPrice());
        System.out.println();
        // SONG 5
        System.out.println("Below is song5 info:");
        System.out.println(song5.getTitle());
        System.out.println(song5.getRating());
        System.out.println(song5.getPrice());
        System.out.println();
        // SONG 6
        System.out.println("Below is song6 info:");
        System.out.println(song6.getTitle());
        System.out.println(song6.getRating());
        System.out.println(song6.getPrice());
        System.out.println();
        // SONG 7
        System.out.println("Below is song7 info:");
        System.out.println(song7.getTitle());
        System.out.println(song7.getRating());
        System.out.println(song7.getPrice());
        System.out.println();
        // SONG 8
        System.out.println("Below is song8 info:");
        System.out.println(song8.getTitle());
        System.out.println(song8.getRating());
        System.out.println(song8.getPrice());
        System.out.println();
        // SONG 9
        System.out.println("Below is song9 info:");
        System.out.println(song9.getTitle());
        System.out.println(song9.getRating());
        System.out.println(song9.getPrice());
        System.out.println();
        // SONG 10
        System.out.println("Below is song10 info:");
        System.out.println(song10.getTitle());
        System.out.println(song10.getRating());
        System.out.println(song10.getPrice());
        System.out.println();
        
        // Create Movie 1
        movie1.setTitle("Interstellar");  
        movie1.setRating(5);  
        
        // Print Movie 1
        System.out.println("Below is movie1 info:");
        System.out.println(movie1.getTitle());
        System.out.println(movie1.getRating());
        System.out.println();
        
        // Create Movie 2
        movie2.setTitle("Forest Gump");  
        movie2.setRating(3);  
        
        // Print Movie 2
        System.out.println("Below is movie2 info:");
        System.out.println(movie2.getTitle());
        System.out.println(movie2.getRating());
        System.out.println();
        
        // Create Book 1
        book1.setTitle("Moby Dick");  
        book1.setRating(2);  
        
        // Print Book 1
        System.out.println("Below is book1 info:");
        System.out.println(book1.getTitle());
        System.out.println(book1.getRating());
        System.out.println();
        
        // Create Book 2
        book2.setTitle("1984");  
        book2.setRating(3);  
        
        // Print Book 2
        System.out.println("Below is book2 info:");
        System.out.println(book2.getTitle());
        System.out.println(book2.getRating());
        System.out.println();
    }
}