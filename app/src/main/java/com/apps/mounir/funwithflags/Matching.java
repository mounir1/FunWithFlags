package com.apps.mounir.funwithflags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by mac on 21/01/16.
 */
public class Matching extends AppCompatActivity {

    Button Matching;
    Button Memory;
    Button Hanging;
    Button Easy;
    Button Normal;
    Button Hard;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    RelativeLayout Games;
    RelativeLayout selector;
    RelativeLayout Difficult;
    String Continent;
    public static final String DIFFICULTY = "Difficulty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgames);
        getSupportActionBar().setTitle("Play Games");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findviews();


    }

    private void findviews() {
        Games = (RelativeLayout) findViewById(R.id.Games);
        selector = (RelativeLayout) findViewById(R.id.Selector);
        Difficult = (RelativeLayout) findViewById(R.id.Difficulties);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Continents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "view selected : " + "" + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Matching = (Button) findViewById(R.id.matching);
        Memory = (Button) findViewById(R.id.memory);
        Hanging = (Button) findViewById(R.id.matching);
        Easy = (Button) findViewById(R.id.button_easy);
        Normal = (Button) findViewById(R.id.Normal);
        Hard = (Button) findViewById(R.id.Hard);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


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
                Matching.setPadding(4, 4, 4, 4);
                Matching.setMaxWidth(500);
                arrayscontents();

                break;
            }
            case R.id.memory: {
                Matching.setVisibility(View.GONE);
                Hanging.setVisibility(View.GONE);
                Memory.setPadding(4, 4, 4, 4);
                Memory.setMaxWidth(500);

                break;
            }
            case R.id.hanging: {
                Matching.setVisibility(View.GONE);
                Memory.setVisibility(View.GONE);
                Hanging.setPadding(4, 4, 4, 4);
                Hanging.setMaxWidth(500);

                break;
            }

        }
        Difficult.setVisibility(View.VISIBLE);
    }

    private void arrayscontents() {

    }


    public void DifficultyHandler(View view) {
        int id = view.getId();
        Intent MatchIntentGame;
        MatchIntentGame = new Intent(this, MatchingGame.class);
        Log.d("GameHandler", "Success");
        if (id == R.id.button_easy) {
            MatchIntentGame.putExtra(DIFFICULTY, "Easy");
        }
//        Log.d("GameHandler", "Success--2");
        else if (id == R.id.Normal)
            MatchIntentGame.putExtra(DIFFICULTY, "Normal");
        else if (id == R.id.Hard)
            MatchIntentGame.putExtra(DIFFICULTY, "Hard");
        startActivity(MatchIntentGame);


    }
}
