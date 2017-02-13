package org.pltw.examples.okmagpie;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    TextToSpeech maggiesVoice;
    EditText keystrokeEditText;
    private TextView txtSpeechInput;
    Button submitTextInputButton;
    Button speechToTextButton;
    Magpie4 maggie;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        keystrokeEditText = (EditText)findViewById(R.id.keystrokeInput);
        submitTextInputButton = (Button)findViewById(R.id.submitTextInput);
        speechToTextButton = (Button)findViewById(R.id.speechToTextButton);
        maggie = new Magpie4();
        final SpeechRecognizer speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        maggiesVoice=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    maggiesVoice.setLanguage(Locale.US);
                    maggiesVoice.setPitch(1.8f);
                }
            }
        });

        submitTextInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = keystrokeEditText.getText().toString();
                processUserInput(userInput);
            }
        });

        speechToTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));

                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.speech_not_supported),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String userInput = result.get(0);
                    txtSpeechInput.setText("You said: " + userInput);
                    processUserInput(userInput);

                }
                break;
            }

        }
    }

    private void processUserInput(String userInput){
        String response = maggie.getResponse(userInput);
        if (!userInput.equals("")) {
            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
            maggiesVoice.speak(response, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else {
            String greeting = maggie.getGreeting();
            Toast.makeText(getApplicationContext(), greeting, Toast.LENGTH_SHORT).show();
            maggiesVoice.speak(greeting, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
}
