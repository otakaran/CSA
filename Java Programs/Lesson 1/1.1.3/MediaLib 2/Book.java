/**
 * Book descrip.
 * 
 * @author (Otakar Andrysek) 
 * @version (2.0)
 * @date (9/14/2016)
 */
public class Book
{
    // Instance variables - replace the example below with your own
    private int rating;
    private String title = "";

    /**
     * Constructor for objects of class Book
     */
    public Book()
    {
        // Initialise instance variables
        rating = 0;
        title = "";
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
}
