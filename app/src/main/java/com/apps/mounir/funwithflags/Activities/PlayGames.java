package com.apps.mounir.funwithflags.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.apps.mounir.funwithflags.R;

import java.util.ArrayList;

/**
 * Created by mac on 21/01/16.
 */
public class PlayGames extends AppCompatActivity implements View.OnClickListener {
    public static ArrayList<String> selected = new ArrayList<>();
    private static final String TAG = "TAG";
    Button Matching;
    Button Memory;
    Button Hanging;
    Button Easy;
    Button Normal;
    Button Hard;
    CheckBox af;
    CheckBox eu;
    CheckBox as;
    CheckBox na;
    CheckBox sa;
    CheckBox oc;
    RelativeLayout Games;
    RelativeLayout selectBox;
    RelativeLayout Difficult;
    Intent Game;


    public static final String DIFFICULTY = "Difficulty";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgames);
        getSupportActionBar().setTitle("Play Games");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findviews();


    }

    private void findviews() {
        Games = (RelativeLayout) findViewById(R.id.Games);
        Difficult = (RelativeLayout) findViewById(R.id.Difficulties);
//        selector = (RelativeLayout) findViewById(R.id.Selector);

        selectBox = (RelativeLayout) findViewById(R.id.CheckboXes);
        selectBox.setVisibility(View.GONE);
        af = (CheckBox) findViewById(R.id.afric);
        eu = (CheckBox) findViewById(R.id.loeurope);
        as = (CheckBox) findViewById(R.id.asi);
        na = (CheckBox) findViewById(R.id.lamericdenord);
        sa = (CheckBox) findViewById(R.id.mericdesude);
        oc = (CheckBox) findViewById(R.id.loceana);

        af.setOnClickListener(this);
        as.setOnClickListener(this);
        eu.setOnClickListener(this);
        na.setOnClickListener(this);
        sa.setOnClickListener(this);
        oc.setOnClickListener(this);

        selected.add("af");
        selected.add("as");
        selected.add("eu");
        selected.add("na");
        selected.add("sa");
        selected.add("oc");

        Matching = (Button) findViewById(R.id.matching);
        Memory = (Button) findViewById(R.id.memory);
        Hanging = (Button) findViewById(R.id.hanging);


        Easy = (Button) findViewById(R.id.button_easy);
        Normal = (Button) findViewById(R.id.Normal);
        Hard = (Button) findViewById(R.id.Hard);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        else if (id == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    public void GameHandler(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.matching: {
                Memory.setVisibility(View.GONE);
                Hanging.setVisibility(View.GONE);
                Game = new Intent(this, MatchingGame.class);
                break;
            }
            case R.id.memory: {
                Matching.setVisibility(View.GONE);
                Hanging.setVisibility(View.GONE);
                Game = new Intent(this, MemoryGame.class);
                Log.d(TAG, "GameHandler: memory");
                break;
            }
            case R.id.hanging: {
                Matching.setVisibility(View.GONE);
                Memory.setVisibility(View.GONE);
                Game = new Intent(this, MatchingGame.class);
                break;
            }
        }
        selectBox.setVisibility(View.VISIBLE);
        Difficult.setVisibility(View.VISIBLE);

    }

    public void DifficultyHandler(View view) {
        int id = view.getId();

        if (id == R.id.button_easy)
            Game.putExtra(DIFFICULTY, "Easy");
        else if (id == R.id.Normal)
            Game.putExtra(DIFFICULTY, "Normal");
        else if (id == R.id.Hard)
            Game.putExtra(DIFFICULTY, "Hard");
        if (selected.size() != 0)
            startActivity(Game);
        else
            Toast.makeText(this, "Please Select at least one set of flags to Play!", Toast.LENGTH_LONG).show();
    }

    public void onClick(View v) {
        CheckBox t = (CheckBox) v;
        if (t.isChecked()) {
            switch (t.getId()) {
                case R.id.afric: {
                    selected.add("af");
                    break;
                }
                case R.id.loeurope: {
                    selected.add("eu");
                    break;
                }
                case R.id.asi: {
                    selected.add("as");

                    break;
                }
                case R.id.lamericdenord: {
                    selected.add("na");

                    break;
                }
                case R.id.mericdesude: {
                    selected.add("sa");
                    break;
                }
                case R.id.loceana: {
                    selected.add("oc");
                    break;
                }

            }
        } else {
            switch (t.getId()) {
                case R.id.afric: {
                    selected.remove("af");
                    break;
                }
                case R.id.loeurope: {
                    selected.remove("eu");

                    break;
                }
                case R.id.asi: {
                    selected.remove("as");


                    break;
                }
                case R.id.lamericdenord: {
                    selected.remove("na");


                    break;
                }
                case R.id.mericdesude: {
                    selected.remove("sa");

                    break;
                }
                case R.id.loceana: {
                    selected.remove("oc");

                    break;
                }

            }
        }

    }
}
