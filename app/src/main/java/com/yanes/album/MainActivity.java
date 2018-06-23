package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    private static final int REQUEST_CODE_ADD=100;
    public String classes= "MainActivity";
    public static String Activity_KEY ="activity";
    public static ArrayList<String> check = new ArrayList<>();
    public static ArrayList<View> position = new ArrayList<>();
    public static ArrayList<Integer> po = new ArrayList<>();
android.support.v7.widget.Toolbar toolbar;
public static int total =0;

    @Override
    protected void onResume() {
       // toolbar.setTitle(total+" coins");
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        NavigationView n =(NavigationView)findViewById(R.id.nav_view);
        n.setItemIconTintList(null);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
       // toolbar.setLogo(R.drawable.coin);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Button album = (Button)findViewById(R.id.album);
        album.setOnClickListener(this);
        Button about_us= (Button) findViewById(R.id.about_us);
        about_us.setOnClickListener(this);
        Button resource= (Button) findViewById(R.id.resources);
        resource.setOnClickListener(this);
        Button game= (Button) findViewById(R.id.game);
        game.setOnClickListener(this);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.inicioItem) {
                    classes= "Resources";
                } else if (item.getItemId() == R.id.buscarItem) {
                    classes="Game_simon";
                } else if (item.getItemId() == R.id.favoritosItem) {
                    classes="Aboutus";
                } else if (item.getItemId() == R.id.perfilItem) {
                    classes="Album";
                }

                return true;
            }
        });
        Intent intent=new Intent(this, Class.forName(classes));
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.album){
            Intent intent=new Intent(this,States.class);
            startActivity(intent);

        }else if(view.getId() == R.id.about_us){
            Intent intent=new Intent(this,Aboutus.class);
            startActivity(intent);


        }else if(view.getId() == R.id.resources){
            Intent intent=new Intent(this,Resources.class);
            startActivity(intent);


        }else if(view.getId() == R.id.game){
        Intent intent=new Intent(this,Game.class);
        startActivityForResult(intent, REQUEST_CODE_ADD);


    }

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_album) {
            // Handle the camera action
        } else if (id == R.id.nav_classifications) {

        } else if (id == R.id.nav_resources) {

        } else if (id == R.id.nav_aboutus) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_ADD) {

            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled ", Toast.LENGTH_SHORT).show();
                return;
            } else if (resultCode == RESULT_OK) {

                int h = 0;

                String high_score = data.getStringExtra(Activity_KEY);
                Log.i("high score", "high score" + high_score);
                h = Integer.parseInt(high_score);
                total+=h;


                toolbar.setTitle(total+ " coins");
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
