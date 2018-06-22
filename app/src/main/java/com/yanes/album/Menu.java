package com.yanes.album;


    import android.app.Activity;
    import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.view.MenuItem;
import android.widget.TextView;

    public class Menu extends Activity {

        private TextView infoTextView;
        private BottomNavigationView bottomNavigationView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.menu);


            bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if (item.getItemId() == R.id.inicioItem) {
                        infoTextView.setText(R.string.inicio);
                    } else if (item.getItemId() == R.id.buscarItem) {
                        infoTextView.setText(R.string.buscar);
                    } else if (item.getItemId() == R.id.favoritosItem) {
                        infoTextView.setText(R.string.favoritos);
                    } else if (item.getItemId() == R.id.perfilItem) {
                        infoTextView.setText(R.string.perfil);
                    }

                    return true;
                }
            });
        }
    }

