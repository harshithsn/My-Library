package com.e.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference lib;

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView textView, textView3, textView4, textView5, textView6, textView7, textView8, c1, c2, c3, c4, c5, c6;
    TextInputLayout username;
    Button book1, book2, book3, book4, book5, book6;
    final int[] a = {5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Hooks

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        toolbar = findViewById(R.id.toolbar);
        username = findViewById(R.id.p_username);
        book1 = findViewById(R.id.book1);
        book2 = findViewById(R.id.book2);
        book3 = findViewById(R.id.book3);
        book4 = findViewById(R.id.book4);
        book6 = findViewById(R.id.book6);
        book5 = findViewById(R.id.book5);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);


        //check


        //Button
//        book1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a[0] = 0;
//            }
//        });
//        book2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a[1] = 1;
//            }
//        });
//        book3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a[2] = 2;
//            }
//        });
//        book4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a[3] = 3;
//            }
//        });
//        book5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a[4] = 4;
//            }
//        });
//        book6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a[5] = 5;
//            }
//        });
//
//        ///////////////////////////////////////////////////////////////////
//
//        final String userLibrary = "Library";
//        lib = FirebaseDatabase.getInstance().getReference().child("Library");
//        lib.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String lib1 = "b1:" + dataSnapshot.child("b1").getValue(String.class);
//                String lib2 = "b2:" + dataSnapshot.child("b2").getValue(String.class);
//                String lib3 = "b3:" + dataSnapshot.child("b3").getValue(String.class);
//                String lib4 = "b4:" + dataSnapshot.child("b4").getValue(String.class);
//                String lib5 = "b5:" + dataSnapshot.child("b5").getValue(String.class);
//                String lib6 = "b6:" + dataSnapshot.child("b6").getValue(String.class);
//
//                for (int i = 0; i < 6; i++) {
//                    if (a[0] == 0) {
//                        c1.setText(lib1);
//                    } else if (a[1] == 1) {
//                        c2.setText(lib2);
//                    } else if (a[2] == 2) {
//                        c3.setText(lib3);
//                    } else if (a[3] == 3) {
//                        c4.setText(lib4);
//                    } else if (a[4] == 4) {
//                        c5.setText(lib5);
//                    } else if (a[4] == 4) {
//                        c6.setText(lib6);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //toolbar
        setSupportActionBar(toolbar);

        //navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation_drawer, R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.setCheckedItem(R.id.nav_home);

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_collection:
                Intent intent = new Intent(MainActivity.this, MyCollection.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                Intent intent1 = new Intent(MainActivity.this, UserProfile.class);
                startActivity(intent1);
                break;
            case R.id.nav_login:
            case R.id.nav_logout:
                Intent intent2 = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(intent2);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    public void checkbook() {
//        final String userLibrary = "Library";
//        lib = FirebaseDatabase.getInstance().getReference().child("Library");
//        lib.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String lib1 = "b1:" + dataSnapshot.child("b1").getValue(String.class);
//                String lib2 = "b2:" + dataSnapshot.child("b2").getValue(String.class);
//                String lib3 = "b3:" + dataSnapshot.child("b3").getValue(String.class);
//                String lib4 = "b4:" + dataSnapshot.child("b4").getValue(String.class);
//                String lib5 = "b5:" + dataSnapshot.child("b5").getValue(String.class);
//                String lib6 = "b6:" + dataSnapshot.child("b6").getValue(String.class);
//
//                for (int i = 0; i < 6; i++) {
//                    if (a[0] == 0) {
//                        c1.setText(lib1);
//                    } else if (a[1] == 1) {
//                        c2.setText(lib2);
//                    } else if (a[2] == 2) {
//                        c3.setText(lib3);
//                    } else if (a[3] == 3) {
//                        c4.setText(lib4);
//                    } else if (a[4] == 4) {
//                        c5.setText(lib5);
//                    } else if (a[4] == 4) {
//                        c6.setText(lib6);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }

}
