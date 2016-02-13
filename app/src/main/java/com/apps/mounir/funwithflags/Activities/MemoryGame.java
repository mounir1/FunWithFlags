package com.apps.mounir.funwithflags.Activities;

import android.os.Handler;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apps.mounir.funwithflags.Helpers.Flag;
import com.apps.mounir.funwithflags.Helpers.GridAdapter;
import com.apps.mounir.funwithflags.R;
import com.apps.mounir.funwithflags.Resources.AFRICA;
import com.apps.mounir.funwithflags.Resources.ASIA;
import com.apps.mounir.funwithflags.Resources.EUROPE;
import com.apps.mounir.funwithflags.Resources.NAmerica;
import com.apps.mounir.funwithflags.Resources.Oceana;
import com.apps.mounir.funwithflags.Resources.SouthAmerica;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mounir on 12.02.2016.
 */
public class MemoryGame extends AppCompatActivity implements GridView.OnItemClickListener {

    private GridView grid;
    private static final String TAG = "TAG";
    private ArrayList<Flag> FlagsofTheGame = new ArrayList<>();
    private ArrayList<Flag> Flagstoprint = new ArrayList<>();
    private String Dificulty;
    private GridAdapter adapter;
    private Handler mhandler = new Handler();

    private TextView number;
    private int mProgress;
    private ProgressBar mProgressBar;
    private TextView progressText;
    private int level;
    private TextView Score;
    private int times = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);
        getSupportActionBar().setTitle("Play Memory Game");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Dificulty = getIntent().getStringExtra(PlayGames.DIFFICULTY);

        Log.d(TAG, "onCreate: ");


        initFlags();
        Log.d(TAG, "onCreate: 2");
        MmemoryGame();
        Log.d(TAG, "onCreate: 3");
    }

    private void MmemoryGame() {
        findviews();
        Log.d(TAG, "MmemoryGame: ");
        adapter = new GridAdapter(this, Flagstoprint);
        grid.setAdapter(adapter);

        start();
        Log.d(TAG, "MmemoryGame: 1");
        play();

    }

    private void findviews() {
        grid = (GridView) findViewById(R.id.gridview);
        progressText = (TextView) findViewById(R.id.progress);
        mProgressBar = (ProgressBar) findViewById(R.id.ProgressBar);
        level = 100;
        Score = (TextView) findViewById(R.id.score);
        Collections.shuffle(FlagsofTheGame);
        for (int i = 0; i < 10; i++) {
            Flagstoprint.add(FlagsofTheGame.get(i));
        }
        Collections.shuffle(Flagstoprint);
        for (int i = 0; i < 10; i++) {
            Flagstoprint.add(FlagsofTheGame.get(i));
        }


    }

    private void play() {
        if (number.getText().equals("0")) {
            number.setVisibility(View.GONE);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < Flagstoprint.size(); i++) {
                Flagstoprint.get(i).setImagId(R.drawable._algeria);
                adapter.notifyDataSetChanged();
            }
            grid.setOnItemClickListener(this);
            progress();
        }

        Log.d(TAG, "play: ");


    }

    private void progress() {
        Log.d(TAG, "from play: ");
        mProgress = 0;
        Log.d(TAG, "progress: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgress < 100) {
                    mProgress += 1;
                    mhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgress);
                            progressText.setText("" + mProgress + "/" + mProgressBar.getMax());
                        }
                    });

                    try {
                        Thread.sleep(level);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                if (mProgress == 100) {
                    GameOver();
                }
            }
        }).start();

    }

    private void GameOver() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.costum);
        dialog.setTitle("Game Over ! ");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("Game Over ! \n" + " you scored : " + Score + "\n in :" + times + " attempts !\nDo you want to try again ?");
        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageResource(R.drawable._algeria);

        Button dialognega = (Button) dialog.findViewById(R.id.answerno);
        dialognega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
                dialog.dismiss();
            }
        });
        Button dialogButton = (Button) dialog.findViewById(R.id.answeryes);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                again();

            }
        });

        dialog.show();
    }

    private void start() {
        number = (TextView) findViewById(R.id.num);

        for (int i = 5; i < 0; i--) {
            number.setText(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        else if (id == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    private void initFlags() {
        Log.d(TAG, "initFlags: 4");
        if (PlayGames.selected.contains("af"))
            for (int i = 0; i < AFRICA.AfricanLongName.length; i++) {

                Flag flag = new Flag(AFRICA.AfricanLongName[i], AFRICA.Africa[i]);

                FlagsofTheGame.add(flag);
            }
        if (PlayGames.selected.contains("eu")) {
            for (int i = 0; i < EUROPE.EuropeanNames.length; i++) {

                Flag flag = new Flag(EUROPE.EuropeanNames[i], EUROPE.Europe[i]);

                FlagsofTheGame.add(flag);
            }
        }
        if (PlayGames.selected.contains("as")) {
            for (int i = 0; i < ASIA.Asia.length; i++) {

                Flag flag = new Flag(ASIA.Names[i], ASIA.Asia[i]);

                FlagsofTheGame.add(flag);
            }
        }
        if (PlayGames.selected.contains("na")) {
            for (int i = 0; i < NAmerica.NAmerica.length; i++) {

                Flag flag = new Flag(NAmerica.Namescountries[i], NAmerica.NAmerica[i]);

                FlagsofTheGame.add(flag);
            }
        }
        if (PlayGames.selected.contains("sa")) {
            for (int i = 0; i < SouthAmerica.SAmerica.length; i++) {

                Flag flag = new Flag(SouthAmerica.Countries[i], SouthAmerica.SAmerica[i]);

                FlagsofTheGame.add(flag);
            }
        }
        if (PlayGames.selected.contains("oc")) {
            for (int i = 0; i < Oceana.Oceana.length; i++) {

                Flag flag = new Flag(Oceana.Names[i], Oceana.Oceana[i]);

                FlagsofTheGame.add(flag);
            }
        }

    }

    private void again() {
        Flagstoprint.clear();
        new MemoryGame();
        Log.d(TAG, "again: match game");

    }

    private void back() {
        Intent back = new Intent(this, PlayGames.class);
        startActivity(back);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        times++;
    }
}
