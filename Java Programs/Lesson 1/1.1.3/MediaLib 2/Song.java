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

    /**
     * Constructor for objects of class Song
     */
    public Song(String title, double price, int rating)
    {
        // Initialise instance variables
        this.rating = rating;
        this.title = title;
        this.price = price;
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
}
