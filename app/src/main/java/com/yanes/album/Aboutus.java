package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by claud on 4/27/2018.
 */

public class Aboutus extends Activity implements NavigationView.OnNavigationItemSelectedListener  {
    android.support.v7.widget.Toolbar toolbar;
    public static String c = "";
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main111);
        NavigationView n = findViewById(R.id.nav_view1);
        n.setItemIconTintList(null);
        n.setNavigationItemSelectedListener(this);

        toolbar = findViewById(R.id.toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i("lleganav", "hh"+c);
                if (item.getItemId() == R.id.HomeItem) {
                    c= "MainActivity";
                } else if (item.getItemId() == R.id.GameItem) {
                    c="Game";
                }  else if (item.getItemId() == R.id.AlbumItem) {
                    c="States";
                }

                start_activity_menu();

                return true;
            }

        });

    }
    public void start_activity_menu(){
        Intent intent = null;
        if(c.equals("MainActivity")){
            intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }else if(c.equals("Game")){
            intent=new Intent(this,Game.class);
            startActivity(intent);
        }else if (c.equals("States")){
            intent=new Intent(this,States.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.nav_album) {
            Intent intent=new Intent(this, States.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_classifications) {

        } else if (id == R.id.nav_resources) {
            Intent intent=new Intent(this, Resources.class);
            startActivity(intent);

        } else if (id == R.id.nav_aboutus) {
            Intent intent=new Intent(this, Aboutus.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}