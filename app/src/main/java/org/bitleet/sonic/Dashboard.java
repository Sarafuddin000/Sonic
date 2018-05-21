package org.bitleet.sonic;

import android.content.Intent;
import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class Dashboard extends AppCompatActivity {

    public TextView UserName;
    public FirebaseAuth mAuth;
    public Button buttonLogout;

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

        FabSpeedDial fabSpeedDial = (FabSpeedDial)findViewById(R.id.FabSpeedDial);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Toast.makeText(Dashboard.this, ""+menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() == null){
            Intent intent = new Intent(Dashboard.this, MainActivity.class);
            finish();
            startActivity(intent);
        }


        FirebaseUser mUser = mAuth.getCurrentUser();

        UserName = findViewById(R.id.UserName);
        UserName.setText("Welcome"+mUser.getDisplayName());
        //UserName.setText(getIntent().getExtras().getString("UserName"));
        buttonLogout = findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
