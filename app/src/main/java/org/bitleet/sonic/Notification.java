package org.bitleet.sonic;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class Notification extends AppCompatActivity {
    TextView textView;
    String message;
    public static final String SHARED_PREFS = "sharedPrefs";

//Notification in dead state
    //Timer for notification remove from Sharedpreferences
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        textView = ( TextView ) findViewById(R.id.notificationBody);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        message = sharedPreferences.getString("message", message);
        textView.setText(message);


//            message = getIntent().getExtras().getString("message");


    }

        }

