package com.apps.mounir.funwithflags;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static final String Extra = "Extra";

    public static final String AllFlags = "All The IOFlags";
    public static final String IOFlags = "International Organizations";
    public static final String Territories = "Territories";
    public static final String AfroFlags = "African Countries";
    public static final String EuroFlags = "Europe Countries";
    public static final String AsiaFlags = "Asian Countries";
    public static final String OceanaFlags = "Oceana Countries";
    public static final String NAmerica = "North American Countries";
    public static final String SAmerica = "South American Countries";
    protected String[] to = {"mounir1badi@gmail.com", "mounir1badi@hotmail.com"};
//    private Firebase mref;

    public static Continents Africa = new Continents("Africa", 1, "The Mother of the World middle of the Earth (30,370,000 sq km) comprises 54 countries. It is the hottest continent and home of the world's largest desert, the Sahara, occupying the 25% of the total area of Africa.");

    public static Continents Europe = new Continents("Europe", 2, "The Old Continent Middle North  (10,180,000 sq km) comprises 51 countries. It is the most developed economically continent with the European Union as the biggest economic and political union in the world.");

    public static Continents Asia = new Continents("Asia", 3, "East the most Populated !  (43,820,000 sq km) includes 50 countries, and it is the most populated continent, the 60% of the total population of the Earth live here.");

    public static Continents NorthAmerica = new Continents("North America", 4, "North west (24,490,000 sq km) includes 23 countries led by the USA as the largest economy in the world.");

    public static Continents SouthAmerica = new Continents("South America", 5, "South West The Lung of earth  (17,840,000 sq km) comprises 12 countries. Here is located the largest forest, the Amazon rainforest, which covers 30% of the South America total area.");

    public static Continents Oceana = new Continents("South East",6,"South East of the world (9,008,500 sq km) includes 14 countries. It is the least populated continent after Antarctica, only 0.3% of the total Earth population live here. ");

    public static Continents Antarctica = new Continents("Antarctica",7,"(13,720,000 sq km) is the coldest continent in the world, completely covered with ice. There are no permanent inhabitants, except of scientists maintaining research stations in Antarctica.");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent MenuIntent, chooser, intent;
        switch (id) {
            case R.id.FlagsList: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, AllFlags);
                startActivity(MenuIntent);
                break;
            }
            case R.id.PlayGames: {
                MenuIntent = new Intent(this, Matching.class);
                startActivity(MenuIntent);
                break;
            }
            case R.id.Territories: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra,Territories );
                startActivity(MenuIntent);
                break;
            }
            case R.id.Europe: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, EuroFlags);
                startActivity(MenuIntent);
                break;
            }
            case R.id.Africa: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, AfroFlags);
                startActivity(MenuIntent);
                break;
            }
            case R.id.Asia: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, AsiaFlags);
                startActivity(MenuIntent);
                break;
            }
            case R.id.NAmerica: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, NAmerica);
                startActivity(MenuIntent);
                break;
            }
            case R.id.SAmerica: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, SAmerica);
                startActivity(MenuIntent);
                break;
            }

            case R.id.Oceana: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, OceanaFlags);
                startActivity(MenuIntent);
                break;
            }
            case R.id.IO: {
                MenuIntent = new Intent(this, FlagList.class);
                MenuIntent.putExtra(Extra, IOFlags);
                startActivity(MenuIntent);
                break;
            }
            case R.id.E_mail: {
                intent = new Intent((Intent.ACTION_SEND));
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "hi, I hope you like my app !");
                intent.putExtra(Intent.EXTRA_TEXT, "hey There How You doing, Any news !!");
                intent.setType("message/rfc822");
                Intent.createChooser(intent, "Send Email");
                chooser = Intent.createChooser(intent, "Send Email");
                startActivity(chooser);

                break;
            }
            case R.id.Address: {
                intent = new Intent(Intent.ACTION_VIEW);
                chooser = Intent.createChooser(intent, "Luanch Maps");
                intent.setData(Uri.parse("geo:19.076,72.877"));
                startActivity(chooser);
                break;
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
