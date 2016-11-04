package org.example.pltw.medialib;

/**
 * Created by 280230 on 11/4/2016.
 */
public class Book {
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

    public void setRating(int r)
    {
        rating = r;
    }
}
