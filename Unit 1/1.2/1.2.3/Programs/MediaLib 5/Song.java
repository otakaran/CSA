/**
 * Song is a class the generates objects (songs) in the Media Lib project.
 * 
 * @author (Otakar Andrysek) 
 * @version (2.1)
 * @date (9/14/2016)
 */

public class Song
{
    // Instance variables
    private int rating;
    private String title = "";
    private double price;
    private boolean favorite;
    
    // Declare Acuumulators
    private static double totalCost;
    private static int numSongs;
    private static int totalRatings;
    private static double averageCost;

    /**
     * Constructor for objects of class Song
     */
    public Song()
    {
        // Initialise instance variables
        rating = 0;
        title = "";
        price = 0.00;
        favorite = false;
    } 
    
    public String getTitle() 
    {
        return title;
    }
    
    public void setTitle(String t) 
    {
        title = t;
    }
    
    public int getRating() 
    {
        return rating;
    }
    
    public void setRating(int r) 
    {
        rating = r;
    }
    
    public double getPrice()      // Added accessor in 1.1.3
    {
        return price;
    }
    
    public void setPrice(double p)      // Added mutator in 1.1.3
    {
        price = p;
    }
    
    public void addToFavorites() 
    {
        favorite = true;
    }
    
    public double getTotalCost() 
    {
        return totalCost;
    }
    
    public int getNumSongs() 
    {
        return numSongs;
    }
    
    public int getTotalRatings() 
    {
        return totalRatings;
    }
    
    public double getAverageCost() 
    {
        return averageCost;
    }
    
    public Song(String title, double price, int rating) {
            this.title = title;
            this.price = price;
            this.rating = rating;
            this.totalCost += price;
            this.numSongs += 1;
            this.totalRatings += rating;
            this.averageCost = totalCost / numSongs;
    }
    
    // New constructor for 1.2.2
    public Song(String title) {
            this.title = title;
            this.numSongs += 1;
            //this.totalRatings += rating;
            //this.averageCost = totalCost / numSongs;
    }
    
    // New constructor for 1.2.3 Part VI
    // Used for Algorithms class
    public Song(String title, int rating) {
            this.title = title;
            this.rating = rating;
            this.numSongs += 1;
            this.totalRatings += rating;
    }
}