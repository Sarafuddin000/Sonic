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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class Dashboard extends AppCompatActivity {

    public TextView UserName;
    public FirebaseAuth mAuth;
    public Button buttonLogout;
    DatabaseReference databaseReference;
    String uid;
    String name;



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
                    /*case R.id.action_earn:
                        Intent intent = new Intent(Dashboard.this, EarnActivity.class);
                        startActivity(intent);
                        break;*/

                   /* case R.id.action_withdraw:
                        Intent intent1 = new Intent(Dashboard.this, Withdraw.class);
                        startActivity(intent1);
                        break;*/

                    case R.id.action_notification:
                        Intent intent2 = new Intent(Dashboard.this, Notification.class);
                        startActivity(intent2);
                        break;

                    case R.id.action_invite:
                        Intent intent3 = new Intent(Dashboard.this, Invite.class);
                        startActivity(intent3);
                        break;

                    case R.id.action_support:
                        Intent intent4 = new Intent(Dashboard.this, Support.class);
                        startActivity(intent4);
                        break;

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
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        uid = mUser.getUid();
        name = mUser.getDisplayName();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Username = dataSnapshot.child(uid).child("name").getValue(String.class);
                UserName = findViewById(R.id.UserName);
                UserName.setText("Welcome " +Username +name +uid);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });


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
