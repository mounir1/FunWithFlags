package com.apps.mounir.funwithflags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by mac on 21/01/16.
 */
public class Matching extends AppCompatActivity {

    public static final String DIFFICULTY = "Difficulty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matching);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    public void MatchingHandler(View view) {
        int id = view.getId();
        Intent MatchIntentGame;
        Log.d("MatchingHandler", "Success");
        if (id == R.id.button_easy) {
            MatchIntentGame = new Intent(this, MatchingGame.class);
            MatchIntentGame.putExtra(DIFFICULTY, "Easy");
            startActivity(MatchIntentGame);
        }
        Log.d("MatchingHandler", "Success--2");
        //else if (id == R.id.Normal)
        //MatchIntentGame.putExtra(DIFFICULTY, "Normal");
        //else if (id == R.id.Hard)
        //MatchIntentGame.putExtra(DIFFICULTY, "Hard");
    }
}
