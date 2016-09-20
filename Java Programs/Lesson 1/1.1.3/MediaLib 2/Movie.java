/**
 * Movie creates movie objects
 * 
 * @author (Otakar Andrysek) 
 * @version (2.2.2)
 * @date (9/16/2016)
 */

public class Movie
{
    // Instance variables
    private int rating;
    private String title = "";
    
    // Duration variables
    private int duration;
    private int hours;
    private int minutes;
    private static int totalDuration;
    private static double averageDuration;

    /**
     * Constructor for objects of class Movie
     */
    public Movie()
    {
        // Initialise instance variables
        rating = 0;
        title = "";
        hours = 0;
        duration = 0;
        minutes = 0;
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
    
    public String getDuration() 
    {
        this.hours = duration / 60;
        this.minutes = duration % 60;
        return "This movie is " + getHours() + " hours and " + getMinutes() + " minutes.";
    }
    
    public void setDuration(int d) 
    {
        duration = d;
    }
    
    public int getHours() 
    {
        return hours;
    }
    
    public int getMinutes() 
    {
        return minutes;
    }
    
    public int getTotalDuration() 
    {
        return totalDuration;
    }
    
    public double getAverageDuration() 
    {
        return averageDuration;
    }
    
    public Movie(String title, int rating) {
        this.title = title;
        this.rating = rating;
        this.totalDuration += duration;
        this.averageDuration = totalDuration / 3;
    }
}