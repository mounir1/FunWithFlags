package com.apps.mounir.funwithflags.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
public class MemoryGame extends Activity implements GridView.OnItemClickListener {

    private GridView grid;
    private static final String TAG = "TAG";
    private ArrayList<Flag> FlagsofTheGame = new ArrayList<>();
    private ArrayList<Flag> Flagstoprint = new ArrayList<>();
    private String Dificulty;
    private GridAdapter adapter;
    private Handler mhandler = new Handler();
    private Handler testHamdler = new Handler();
    private static int test;
    private TextView number;
    private int mProgress;
    private ProgressBar mProgressBar;
    private TextView progressText;
    private int level;
    private TextView Score;
    private int times = 0;
    int Flag_size = 20;
    private Dialog dialog;
    private Boolean first = false;
    private int[] FlagsId = new int[Flag_size];
    Flag flag1;
    Flag flag2;
    int temp = 0;
    int temp1 = 0;
    private int SCORE = 0;
    int n = 5;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);
//        getSupportActionBar().setTitle("Play Memory Game");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Dificulty = getIntent().getStringExtra(PlayGames.DIFFICULTY);
        Log.d(TAG, "onCreate: " + Dificulty);


        initFlags();
        Log.d(TAG, "onCreate: 2+ initialized");
        MmemoryGame();
        Log.d(TAG, "MmemoryGame: mProgress : " + mProgress);

    }

    private void MmemoryGame() {
        findviews();
        Log.d(TAG, "MmemoryGame: ");
        adapter = new GridAdapter(this, Flagstoprint);
        grid.setAdapter(adapter);

        starting();
        Thread.currentThread().setName("Main");

        Log.d(TAG, "MmemoryGame: mProgress : " + mProgress);
        if (mProgress == 100)
            GameOver();
        Log.d(TAG, "MmemoryGame: 1");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        dialog.setOnKeyListener(new Dialog.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface arg0, int keyCode,
                                 KeyEvent event) {
                // TODO Auto-generated method stub
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    finish();
                    dialog.dismiss();
                }
                return true;
            }
        });
        return false;
    }

    private void findviews() {
        grid = (GridView) findViewById(R.id.gridview);
        progressText = (TextView) findViewById(R.id.progress);
        mProgressBar = (ProgressBar) findViewById(R.id.ProgressBar);
        level = 100;
        Score = (TextView) findViewById(R.id.score);
        Collections.shuffle(FlagsofTheGame);
        for (int i = 0; i < 20; i++) {
            Flagstoprint.add(FlagsofTheGame.get(i));
        }

//        for (int i = 0; i < 20; i++) {
//            Flagstoprint.add(FlagsofTheGame.get(i));
//        }
//        Collections.shuffle(Flagstoprint);
        //stor all the ids in other array !
        for (int i = 0; i < 20 ; i++) {
            FlagsId[i] = Flagstoprint.get(i).getImagId();
        }


    }

    final void play() {

        for (int i = 0; i < Flagstoprint.size(); i++) {
            Flagstoprint.get(i).setImagId(R.drawable._algeria);
            adapter.notifyDataSetChanged();
        }
        grid.setOnItemClickListener(this);

        level = 1000;
        progress();
        Log.d(TAG, "play: ");


    }

    private void progress() {
        mProgress = 0;
        Thread.currentThread().getName();
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
                    if (mProgress == 100)
                        play();
                    try {
                        Thread.sleep(level);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                GameOver();
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

    private void starting() {
        final TextView num = (TextView) findViewById(R.id.num);
        timer = new CountDownTimer(10000, 10) {
            public void onTick(long millisUntilFinished) {


                num.setText("" + (millisUntilFinished));


            }


            public void onFinish() {


                num.setText("go!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                play();
                num.setVisibility(View.GONE);

            }
        };


        timer.start();


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
        finish();
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

        if (!first) {
            // display the flag !

            temp = FlagsId[position];
            Log.d(TAG, "onItemClick: !first  " + temp);


            Log.d(TAG, "onItemClick: !first  " + position);
            Flagstoprint.get(position).setImagId(FlagsId[position]);


            adapter.notifyDataSetChanged();
            first = true;
        } else {
            flag1 = Flagstoprint.get(position);
            temp1 = FlagsId[position];
            Flagstoprint.get(position).setImagId(temp);
            adapter.notifyDataSetChanged();
            Log.d(TAG, "onItemClick second time : " + temp1 + "position" + position);

            //checking result
            if (temp1 == temp)
                scored();
            else
                failed();
        }
    }

    private void failed() {
        first = false;
        for (Flag flag : Flagstoprint) {
            if (flag.getImagId() == temp || flag.getImagId() == temp1)
                flag.setImagId(R.drawable._algeria);
            adapter.notifyDataSetChanged();
        }
        SCORE -= 10;
    }

    private void scored() {

        first = false;
        SCORE += 50;
        for (Flag flag : Flagstoprint) {
            if (flag.getImagId() == temp)
                Flagstoprint.remove(flag);
            adapter.notifyDataSetChanged();
        }

    }
}
