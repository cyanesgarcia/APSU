package com.yanes.album;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;


    public class Game extends Activity {
        private CircleMenu circleMenu;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game);
            circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

            circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.icon_menu, R.mipmap.icon_cancel);
            circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.icon_home)
                    .addSubMenu(Color.parseColor("#30A400"), R.mipmap.icon_search)
                    .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon_notify)
                    .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.icon_setting)
                    .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.icon_gps);

            circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                     @Override
                                                     public void onMenuSelected(int index) {
                                                         switch (index) {
                                                             case 0:
                                                                 Toast.makeText(com.yanes.album.Game.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();
                                                                 break;

                                                             case 1:
                                                                 Toast.makeText(com.yanes.album.Game.this, "Search Button Clicked", Toast.LENGTH_SHORT).show();
                                                                 break;

                                                             case 2:
                                                                 Toast.makeText(com.yanes.album.Game.this, "Modify Button Clicked", Toast.LENGTH_SHORT).show();
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
            circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
                @Override
                public void onMenuOpened() {
                    Toast.makeText(com.yanes.album.Game.this, "Menu Opened", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onMenuClosed() {
                    Toast.makeText(com.yanes.album.Game.this, "Menu Closed", Toast.LENGTH_SHORT).show();

                }
            });
        }
        @Override
        public void onBackPressed(){
            if(circleMenu.isOpened())
                circleMenu.closeMenu();
            else
                finish();
        }

    }

