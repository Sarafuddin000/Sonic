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
                switch (menuItem.getItemId()){
                    case R.id.action_earn:
                        Intent intent = new Intent(Dashboard.this, EarnActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_withdraw:
                        Intent intent1 = new Intent(Dashboard.this, EarnActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.action_notification:
                        Intent intent2 = new Intent(Dashboard.this, EarnActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.action_invite:
                        Intent intent3 = new Intent(Dashboard.this, EarnActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.action_support:
                        Intent intent4 = new Intent(Dashboard.this, EarnActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.action_report:
                        Intent intent5 = new Intent(Dashboard.this, EarnActivity.class);
                        startActivity(intent5);
                        break;


                    default:
                        Toast.makeText(Dashboard.this, ""+menuItem.getTitle(),Toast.LENGTH_SHORT).show();

                }

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
