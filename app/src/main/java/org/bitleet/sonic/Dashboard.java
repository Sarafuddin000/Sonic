package org.bitleet.sonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    public TextView UserName;

   /* @Override
    protected void onStart() {
        super.onStart();
        if (mUser != null){
            finish();
            Intent intent = new Intent(Dashboard.this, MainActivity.class);
            startActivity(intent);
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        UserName = findViewById(R.id.UserName);
        UserName.setText(getIntent().getExtras().getString("UserName"));

    }
}
