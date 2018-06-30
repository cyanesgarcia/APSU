package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;


    public class Game extends Activity implements NavigationView.OnNavigationItemSelectedListener {
        private CircleMenu circleMenu;
        android.support.v7.widget.Toolbar toolbar;
        public static String c = "";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main1111);
            NavigationView n = findViewById(R.id.nav_view1);
            n.setItemIconTintList(null);
            n.setNavigationItemSelectedListener(this);


            circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
            circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_menu, R.mipmap.icon_cancel);
            circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.icon_simon)
                    .addSubMenu(Color.parseColor("#30A400"), R.mipmap.icon_poker)
                    .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon_RSP)
                    .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.icon_setting)
                    .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.icon_gps);

            circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                     @Override
                                                     public void onMenuSelected(int index) {
                                                         switch (index) {
                                                             case 0:
                                                                 new Handler().postDelayed(new Runnable() {
                                                                     @Override
                                                                     public void run() {
                                                                         Intent intent = new Intent(Game.this, Game_simon.class);
                                                                         Game.this.startActivity(intent);
                                                                         Game.this.finish();
                                                                     }
                                                                 }, 1000);

                                                                 break;

                                                             case 1:
                                                                 new Handler().postDelayed(new Runnable() {
                                                                     @Override
                                                                     public void run() {
                                                                         Intent intent = new Intent(Game.this, Game_Blackjack.class);
                                                                         Game.this.startActivity(intent);
                                                                         Game.this.finish();
                                                                     }
                                                                 }, 1000);

                                                                 break;

                                                              case 2:
                                                                  new Handler().postDelayed(new Runnable() {
                                                                      @Override
                                                                      public void run() {
                                                                          Intent intent = new Intent(Game.this, RockPaperScissors.class);
                                                                          Game.this.startActivity(intent);
                                                                          Game.this.finish();
                                                                      }
                                                                  }, 1000);
                                                                 break;
                                                             case 3:
                                                                 Toast.makeText(com.yanes.album.Game.this, "Settings Button Clicked", Toast.LENGTH_SHORT).show();
                                                                 break;
                                                             case 4:
                                                                 Toast.makeText(com.yanes.album.Game.this, "GPS Button Clicked", Toast.LENGTH_SHORT).show();
                                                                 break;
                                                         }
                                                     }
                                                 }
            );
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
                Intent intent = new Intent(this, States.class);
                startActivity(intent);
                // Handle the camera action
            } else if (id == R.id.nav_classifications) {

            } else if (id == R.id.nav_resources) {
                Intent intent = new Intent(this, Resources.class);
                startActivity(intent);

            } else if (id == R.id.nav_aboutus) {
                Intent intent = new Intent(this, Aboutus.class);
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

            if (circleMenu.isOpened())
                circleMenu.closeMenu();
            else
                finish();
        }
    }

