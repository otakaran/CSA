/**
 * MediaLib the the wrapper class for the whole program. This program stores various sorts
 * of media (songs, movies, and book) with data about each one. This is an introductory p-
 * rogram to learn about objects and classes in Java.
 * 
 * @author (Otakar Andrysek) 
 * @version (2.0)
 * @date (9/14/2016)
 */
public class MediaLib
{
    public static void main()
    {
        // Welcome user
        System.out.println("Welcome to your Media Library");
        
        // Initialize objects
        Song song1 = new Song();
        Song song2 = new Song();
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Book book1 = new Book();
        Book book2 = new Book();
        
        // Print my collection
        System.out.println(song1);
        System.out.println(song2);
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(book1);
        System.out.println(book2);
        
        // Create Song 1
        song1.setTitle("Johnny B. Goode");  
        System.out.println(song1.getTitle());
        song1.setRating(3);  
        System.out.println(song1.getRating());
        song1.setPrice(12.99);
        System.out.println(song1.getRating());
        
        // Create Song 2
        song2.setTitle("John Cena Theme");  
        System.out.println(song2.getTitle());
        song2.setRating(5);  
        System.out.println(song2.getRating());
        song2.setPrice(100.00);
        System.out.println(song2.getRating());
        
        // Create Movie 1
        movie1.setTitle("Interstellar");  
        System.out.println(movie1.getTitle());
        movie1.setRating(5);  
        System.out.println(movie1.getRating());
        
        // Create Movie 2
        movie2.setTitle("Forest Gump");  
        System.out.println(movie2.getTitle());
        movie2.setRating(3);  
        System.out.println(movie2.getRating());
        
        // Create Book 1
        book1.setTitle("Moby Dick");  
        System.out.println(book1.getTitle());
        book1.setRating(2);  
        System.out.println(book1.getRating());
        
        // Create Book 2
        book2.setTitle("1984");  
        System.out.println(book2.getTitle());
        book2.setRating(3);  
        System.out.println(book2.getRating());
    }
}