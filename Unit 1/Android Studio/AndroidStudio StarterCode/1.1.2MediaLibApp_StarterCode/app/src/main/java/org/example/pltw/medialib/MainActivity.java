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
        outputText.append("none");
    }
}
