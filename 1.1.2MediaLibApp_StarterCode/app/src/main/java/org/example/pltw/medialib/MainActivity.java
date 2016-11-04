package org.example.pltw.medialib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = (TextView) findViewById(R.id.welcomeTextView);
        ;
    }

    /**
     * This method is called when the Show Contents button is clicked
     **/
    public void showMedia(View v) {
            TextView outputText = (TextView) findViewById(R.id.mediaLibText);
            // Welcome the user
            outputText.append("Welcome to your Media Library");

            // Songs
            Song song1 = new Song("Hello", 1.29, 3);
            outputText.append(song1.getTitle());
            outputText.append("%n");

            Song song2 = new Song("Goodbye", 1.29, 4);
            outputText.append(String.valueOf(song2.getTitle()));
            outputText.append(String.valueOf(song2.getPrice()));
            outputText.append(String.valueOf(song2.getRating()));
            outputText.append("%n");

            // Printing extra song data
            outputText.append(String.valueOf(song1.getTotalCost()));
            outputText.append(String.valueOf(song1.getNumSongs()));
            outputText.append(String.valueOf(song1.getTotalRatings()));
            outputText.append(String.valueOf(song1.getAverageCost()));

            // Movies
            Movie movie1 = new Movie("Cars", 154, 8);
            outputText.append(movie1.getTitle());
            outputText.append(String.valueOf(movie1.getRating()));
            outputText.append(movie1.getDuration());

            Movie movie2 = new Movie("Hobbit", 153, 4);
            outputText.append(movie2.getTitle());
            outputText.append(String.valueOf(movie2.getRating()));
            outputText.append(movie2.getDuration());

            Movie movie3 = new Movie("Rabbit", 100, 7);
            outputText.append(movie3.getTitle());
            outputText.append(String.valueOf(movie3.getRating()));
            outputText.append(movie3.getDuration());

            // Printing extra movie data
            outputText.append(movie3.getTotalDuration());
            outputText.append(movie3.getAverageDuration());

            // Book(s)
            Book book1 = new Book();
            outputText.append(String.valueOf(book1));
            book1.setTitle("Calculus");
            outputText.append(book1.getTitle());
            book1.setRating(1);
            outputText.append(String.valueOf(book1.getRating()));
        }
}