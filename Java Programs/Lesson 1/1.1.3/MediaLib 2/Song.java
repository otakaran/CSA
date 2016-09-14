/**
 * Song is a class the generates objects (songs) in the Media Lib project.
 * 
 * @author (Otakar Andrysek) 
 * @version (2.0)
 * @date (9/14/2016)
 */
public class Song
{
    // Instance variables
    private int rating;
    private String title = "";
    private double price;
    private boolean favorite;

    /**
     * Constructor for objects of class Song
     */
    public Song()
    {
        // Initialise instance variables
        rating = 0;
        title = "";
        price = 0.0;
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
    
    public void setRating(int t) 
    {
        rating = 1;
    }
    
    public double getPrice()      // Added accessor in 1.1.3
    {
        return price;
    }
    
    public void setPrice(double p)      // Added mutator in 1.1.3
    {
        price = p;
    }
    
    public void addToFavorites()        // This mutator sets a song as a favorite
    {
        favorite = true;
    }
    
    public boolean getFavorite()
    {
        return favorite;
    }
}
