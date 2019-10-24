package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class Resources extends Activity implements  NavigationView.OnNavigationItemSelectedListener {

    android.support.v7.widget.Toolbar toolbar;
    public static String c = "";
    protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main11);
        NavigationView n = findViewById(R.id.nav_view1);
        n.setItemIconTintList(null);
        n.setNavigationItemSelectedListener(this);

        toolbar = findViewById(R.id.toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        TextView CCA= (TextView)findViewById(R.id.CCA);
        CCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://owlcation.com/humanities/Why-Sacramento-Is-The-Capital-Of-California");
            }
        });
        TextView CFL= (TextView)findViewById(R.id.CFL);
        CFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("http://www.floridamemory.com/blog/2013/03/04/tallahassee-designated-capital-of-the-florida-territory/");
            }
        });
        TextView CGA= (TextView)findViewById(R.id.CGA);
        CGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.georgiaencyclopedia.org/articles/counties-cities-neighborhoods/georgias-historic-capitals");
            }
        });
        TextView CHI= (TextView)findViewById(R.id.CHI);
        CHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.encyclopedia.com/places/united-states-and-canada/us-political-geography/honolulu");
            }
        });
        TextView CNY= (TextView)findViewById(R.id.CNY);
        CNY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.quora.com/Why-is-Albany-the-capital-of-New-York");
            }
        });
        TextView CTN= (TextView)findViewById(R.id.CTN);
        CTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.quora.com/How-did-Nashville-become-Tennessees-state-capital");
            }
        });
        TextView CTX= (TextView)findViewById(R.id.CTX);
        CTX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("http://www.austinrelocationguide.com/History-of-Austin/");
            }
        });
    TextView FCA= (TextView)findViewById(R.id.FCA);
    FCA.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               goToUrl("https://matadornetwork.com");
           }
       });
        TextView FFL= (TextView)findViewById(R.id.FFL);
        FFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.google.com/amp/www.onlyinyourstate.com/florida/favorite-foods-fl/amp/#ampshare=http://www.onlyinyourstate.com/florida/favorite-foods-fl/");
            }
        });
        TextView FGA= (TextView)findViewById(R.id.FGA);
        FGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("http://www.katherinebelarmino.com/2016/05/georgian-cuisine-traditional-foods.html?m=1");
            }
        });
        TextView FHI= (TextView)findViewById(R.id.FHI);
        FHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.huffingtonpost.com/2015/03/04/hawaii-food-bucket-list_n_6738518.html");
            }
        });
        TextView FNY= (TextView)findViewById(R.id.FNY);
        FNY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.bbcgoodfood.com/howto/guide/top-10-foods-try-new-york");
            }
        });
        TextView FTN= (TextView)findViewById(R.id.FTN);
        FTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://theculturetrip.com/north-america/usa/tennessee/articles/11-iconic-tennessee-foods-you-need-to-try");
            }
        });
        TextView FTX= (TextView)findViewById(R.id.FTX);
        FTX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.guidelive.com/food-and-drink/2015/01/15/12-essential-texas-foods-and-drinks-and-where-to-find-them");
            }
        });
        TextView PCA= (TextView)findViewById(R.id.PCA);
        PCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://travel.usnews.com/rankings/best-places-to-visit-in-california/");
            }
        });
        TextView PFL= (TextView)findViewById(R.id.PFL);
        PFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("http://www.touropia.com/best-places-to-visit-in-florida/");
            }
        });
        TextView PGA= (TextView)findViewById(R.id.PGA);
        PGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://vacationidea.com/destinations/best-places-to-visit-in-georgia.html");
            }
        });
        TextView PHI= (TextView)findViewById(R.id.PHI);
        PHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("http://www.touropia.com/best-places-to-visit-in-hawaii/");
            }
        });
        TextView PNY= (TextView)findViewById(R.id.PNY);
        PNY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.planetware.com/tourist-attractions-/new-york-city-us-ny-nyc.htm");
            }
        });
        TextView PTN= (TextView)findViewById(R.id.PTN);
        PTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.planetware.com/tourist-attractions/tennessee-ustn.htm");
            }
        });
        TextView PTX= (TextView)findViewById(R.id.PTX);
        PTX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.planetware.com/tourist-attractions/texas-ustx.htm");
            }
        });

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
            finish();

        }else if(c.equals("Game")){
           intent=new Intent(this,Game.class);
           startActivity(intent);
            finish();

        }else if (c.equals("States")){
            intent=new Intent(this,States.class);
            startActivity(intent);
            finish();

        }

    }
public String goToUrl(String st){
        Uri uri= Uri.parse(st);
        Intent intent= new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        return st;
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
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
           // super.onBackPressed();
        }

    }
}
