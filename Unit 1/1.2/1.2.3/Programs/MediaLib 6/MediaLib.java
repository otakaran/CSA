/**
 * MediaLib the the wrapper class for the whole program. This program stores various sorts
 * of media (songs, movies, and book) with data about each one. This is an introductory p-
 * rogram to learn about objects and classes in Java.
 * 
 * @author (Otakar Andrysek) 
 * @version (3.0)
 * @date (10/20/2016)
 */

public class MediaLib
{
   public static void main() {
       // Welcome the user
       System.out.println("Welcome to your Media Library");
       
       // Songs
       Song song1 = new Song("Hello", 1.29, 3);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song1.getTitle(), song1.getPrice(), song1.getRating());
       System.out.printf("%n");
       
       Song song2 = new Song("Goodbye", 1.29, 4);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song2.getTitle(), song2.getPrice(), song2.getRating());
       System.out.printf("%n");
       
       Song song3 = new Song("Shoe", .99, 8);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song3.getTitle(), song3.getPrice(), song3.getRating());
       System.out.printf("%n");
       
       Song song4 = new Song("Water", .99, 3);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song4.getTitle(), song4.getPrice(), song4.getRating());
       System.out.printf("%n");
       
       Song song5 = new Song("Cow", 1.29, 8);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song5.getTitle(), song5.getPrice(), song5.getRating());
       System.out.printf("%n");
       
       Song song6 = new Song("Grass", .99, 10);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song6.getTitle(), song6.getPrice(), song6.getRating());
       System.out.printf("%n");
       
       Song song7 = new Song("Fire", .99, 5);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song7.getTitle(), song7.getPrice(), song7.getRating());
       System.out.printf("%n");
       
       Song song8 = new Song("Computer", .99, 3);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song8.getTitle(), song8.getPrice(), song8.getRating());
       System.out.printf("%n");
       
       Song song9 = new Song("Hamster", 1.29, 6);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song9.getTitle(), song9.getPrice(), song9.getRating());
       System.out.printf("%n");
       
       Song song10 = new Song("Oregon", .99, 5);
       System.out.printf("Title: %s\nPrice: %s\nRating: %s", song10.getTitle(), song10.getPrice(), song10.getRating());
       System.out.printf("%n");
       
       // Printing extra song data
       System.out.println(song1.getTotalCost());
       System.out.println(song1.getNumSongs());
       System.out.println(song1.getTotalRatings());
       System.out.println(song1.getAverageCost());
       System.out.println();
       
       // Movies
       Movie movie1 = new Movie("Cars", 154, 8);
       System.out.println(movie1.getTitle());
       System.out.println(movie1.getRating());
       System.out.println(movie1.getDuration());
       
       Movie movie2 = new Movie("Hobbit", 153, 4);
       System.out.println(movie2.getTitle());
       System.out.println(movie2.getRating());
       System.out.println(movie2.getDuration());
       
       Movie movie3 = new Movie("Rabbit", 100, 7);
       System.out.println(movie3.getTitle());
       System.out.println(movie3.getRating());
       System.out.println(movie3.getDuration());
       
       // Printing extra movie data
       System.out.println(movie3.getTotalDuration());
       System.out.println(movie3.getAverageDuration());
       System.out.println();
       
       // Book(s)
       Book book1 = new Book();
       System.out.println(book1);
       book1.setTitle("Calculus");
       System.out.println(book1.getTitle());
       book1.setRating(1);
       System.out.println(book1.getRating());
   }
}