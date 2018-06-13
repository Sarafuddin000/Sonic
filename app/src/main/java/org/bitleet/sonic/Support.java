package org.bitleet.sonic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Support extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        ImageView facebook = findViewById(R.id.facebook);
        ImageView messenger = findViewById(R.id.messenger);
        ImageView youtube = findViewById(R.id.youtube);
        ImageView bloodman = findViewById(R.id.bloodman);
        ImageView googleplus = findViewById(R.id.googleplus);
        ImageView unickmart = findViewById(R.id.unickmart);



        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this, "Facebook pressed", Toast.LENGTH_SHORT).show();
            }
        });
        messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this, "Messenger pressed", Toast.LENGTH_SHORT).show();
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this, "YouTube pressed", Toast.LENGTH_SHORT).show();

            }
        });
        bloodman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this, "Bloodman pressed", Toast.LENGTH_SHORT).show();

            }
        });
        googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this, "Plus pressed", Toast.LENGTH_SHORT).show();

            }
        });
        unickmart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Support.this, "Unickamrt pressed", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
