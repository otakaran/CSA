package org.example.pltw.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

    }


    /**
     * This method is called when the Say Hello button is clicked. The button's XML has an onSubmit
     * attribute that calls the public function sayHello.
     * nameText is an editable text layout component in XML , so this method uses getEditableText
     * to extract whatever text is currently in the nameText view on the device. The local variable
     * nameEntered is set to type EditText so that it can reference the nameText view.
     **/

    public void sayHello(View v) {
        EditText nameEntered = (EditText) findViewById(
                R.id.nameEditView);
        /* Set the Greeting in helloText with this new name */
        TextView greetingText = (TextView) findViewById(
                R.id.helloText);
        greetingText.setText("Hi" + " " + nameEntered.getEditableText() + ", nice to meet you!");

    }
}

