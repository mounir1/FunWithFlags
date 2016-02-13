package com.apps.mounir.funwithflags.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.mounir.funwithflags.Helpers.GridAdapter;
import com.apps.mounir.funwithflags.Resources.AFRICA;
import com.apps.mounir.funwithflags.Resources.ASIA;
import com.apps.mounir.funwithflags.Resources.EUROPE;
import com.apps.mounir.funwithflags.Helpers.Flag;
import com.apps.mounir.funwithflags.Resources.NAmerica;
import com.apps.mounir.funwithflags.Resources.Oceana;
import com.apps.mounir.funwithflags.R;
import com.apps.mounir.funwithflags.Resources.SouthAmerica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by mac on 21/01/16.
 */
public class MatchingGame extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private static final String TAG = "TAG";
    private ArrayList<Button> Buttons = new ArrayList<>();

    private ProgressBar mProgressBar;
    private static int mProgress = 0;
    private Handler mhandler = new Handler();
    int africa[] = AFRICA.Africa;
    TextView countryName;
    TextView progressText;
    TextView SCORE;
    private Random rand = new Random();
    String textView;
    private int times = 0;
    ArrayList<Integer> array = new ArrayList<>();
    ArrayList<Integer> indexes = new ArrayList<>();
    private static int Score = 0;
    TableLayout tableLayout;
    int level;
    ArrayList<Flag> GameFlags = new ArrayList<>();
    ArrayList<Flag> FlagsOfTheGame = new ArrayList<>();
    private String Dificulty;
    int random;
    private Boolean Done = false;
    GridView grid;
    GridAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_game);
        getSupportActionBar().setTitle("Play Matching Game");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Dificulty = getIntent().getStringExtra(PlayGames.DIFFICULTY);
        findviews();
        initFlags();
        MatchingGame();


    }

    private void MatchingGame() {
        mProgress = 0;
        Score = 0;
        array.clear();
        startGame();
    }

    private void initFlags() {
        if (PlayGames.selected.contains("af"))
            for (int i = 0; i < AFRICA.AfricanLongName.length; i++) {

                Flag flag = new Flag(AFRICA.AfricanLongName[i], AFRICA.Africa[i]);

                GameFlags.add(flag);
            }
        if (PlayGames.selected.contains("eu")) {
            for (int i = 0; i < EUROPE.EuropeanNames.length; i++) {

                Flag flag = new Flag(EUROPE.EuropeanNames[i], EUROPE.Europe[i]);

                GameFlags.add(flag);
            }
        }
        if (PlayGames.selected.contains("as")) {
            for (int i = 0; i < ASIA.Asia.length; i++) {

                Flag flag = new Flag(ASIA.Names[i], ASIA.Asia[i]);

                GameFlags.add(flag);
            }
        }
        if (PlayGames.selected.contains("na")) {
            for (int i = 0; i < NAmerica.NAmerica.length; i++) {

                Flag flag = new Flag(NAmerica.Namescountries[i], NAmerica.NAmerica[i]);

                GameFlags.add(flag);
            }
        }
        if (PlayGames.selected.contains("sa")) {
            for (int i = 0; i < SouthAmerica.SAmerica.length; i++) {

                Flag flag = new Flag(SouthAmerica.Countries[i], SouthAmerica.SAmerica[i]);

                GameFlags.add(flag);
            }
        }
        if (PlayGames.selected.contains("oc")) {
            for (int i = 0; i < Oceana.Oceana.length; i++) {

                Flag flag = new Flag(Oceana.Names[i], Oceana.Oceana[i]);

                GameFlags.add(flag);
            }
        }

    }

    private void findviews() {

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressText = (TextView) findViewById(R.id.progresstext);
        countryName = (TextView) findViewById(R.id.textcountry);
        SCORE = (TextView) findViewById(R.id.scoretxt);
    }

    private void startGame() {

        Collections.shuffle(GameFlags);
        switch (Dificulty) {
            case "Easy": {
                level = 1000;
                drawGrid(12);
                break;
            }
            case "Normal": {
                level = 500;
                drawGrid(12);
                break;
            }
            case "Hard": {
                level = 200;
                drawGrid(12);
                break;
            }

        }

        progress();
        play();
    }

    private void progress() {
        mProgress = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgress < 100 && !Done) {
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

            }
        }).start();
        if (mProgress == 100) {
            GameOver();
        }

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

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        else if (id == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    private void drawGrid(int s) {

        grid = (GridView) findViewById(R.id.matchGrid);
        Log.d(TAG, "onCreate: 2");
        for (int i = 0; i < s; i++) {
            FlagsOfTheGame.add(GameFlags.get(i));
        }
        adapter = new GridAdapter(this, FlagsOfTheGame);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            TableRow row = new TableRow(this);
////            row.setLayoutParams(new TableLayout.LayoutParams(
////                    TableLayout.LayoutParams.MATCH_PARENT,
////                    TableLayout.LayoutParams.MATCH_PARENT
////
////            ));
//
//            tableLayout.addView(row);
//            for (int j = 0; j < m; j++) {
//                final int index = count;
//                Button btn = new Button(this);
//
//                btn.setBackgroundColor(getResources().getColor(R.color.transparent));
//
//                btn.setBackgroundResource(GameFlags.get(index).getImagId());
//                indexes.add(index);
//                btn.setMinimumWidth(120);
//                btn.setMinHeight(100);
//                btn.setMaxHeight(100);
//                btn.setMaxWidth(120);
//
//                btn.setPadding(10, 10, 10, 10);
//                btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (!array.contains(index))
//                            checkClicked(index);
//                    }
//                });
//                Buttons.add(btn);
//                row.addView(btn);

//                count++;
//            }
//
//        }


    }

    private void play() {
        Log.d(TAG, "play: ");
        if (array.size() == 12)
            done();
        else {
            do {
                random = rand.nextInt(12);
            } while (array.contains(random));
            textView = GameFlags.get(random).getFlagName();
            countryName.setText(textView);
        }
    }

    private void checkClicked(int index) {

        Toast.makeText(this, "Button :  " + index + " Clicked", Toast.LENGTH_SHORT).show();
//        countryName.setText(GameFlags.get(index).getFlagName());
    }

    private void wrong() {
        Score -= 10;
//        Toast.makeText(this, "Wrong ", Toast.LENGTH_SHORT).show();
        //  Log.d("TAG", "wrong: ");
    }

    private void correct(int i) {
        //GameFlags.remove(random);
        Score += 20;
        array.add(i);
        //Log.d("TAG", "correct: " + GameFlags.size());

    }

    private void done() {
        Done = true;
        //mProgressBar.setTop(mProgress);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.costum);
        dialog.setTitle("Well Done ! ");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);

        text.setText("Congrats \n" + " you scored : " + Score + "\n in :" + times + " attempts !\n" +
                "Do you want to try again ?");

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
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < (100 - mProgress); i++) {
                    Score++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private void again() {
        FlagsOfTheGame.clear();
        new MatchingGame();
        Log.d(TAG, "again: match game");

//        Intent again = new Intent(this, MatchingGame.class);
//        startActivity(again);
    }

    private void back() {
        Intent back = new Intent(this, PlayGames.class);
        startActivity(back);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "flag : " + position, Toast.LENGTH_SHORT).show();
        times++;
        if (GameFlags.get(position).getFlagName().equals(textView)) {
            correct(position);
            GameFlags.get(position).setImagId(R.drawable._algeria);
            adapter.notifyDataSetChanged();
            if (mProgress == 100)
                GameOver();
            play();
        } else {
            wrong();
        }
        SCORE.setText("Score : " + Score);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.d(TAG, "onSaveInstanceState: ");
////        outState.getCharSequenceArrayList("key", GameFlags.);
//
//    }

    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}



