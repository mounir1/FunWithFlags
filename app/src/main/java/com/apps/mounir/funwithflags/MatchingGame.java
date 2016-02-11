package com.apps.mounir.funwithflags;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import java.util.logging.LogRecord;

/**
 * Created by mac on 21/01/16.
 */
public class MatchingGame extends AppCompatActivity implements View.OnClickListener {


//    public static ArrayList<Integer> ListofFlags = new ArrayList<>();
//
//
//    private ArrayList<Integer> IDS = MainFragment.FlagIds;
//    private ArrayList<String> Names = MainFragment.FlagsName;

    private ArrayList<Button> Buttons = new ArrayList<>();

    private ProgressBar mProgressBar;
    private int mProgress = 0;
    private Handler mhandler = new Handler();
    int africa[] = AFRICA.Africa;
    TextView countryName;
    TextView progressText;
    private Random rand = new Random();
    String textView;
    ArrayList<Integer> array = new ArrayList<>();
    ArrayList<Integer> indexes = new ArrayList<>();
    ArrayList<int[]> African = new ArrayList<>(Arrays.asList(africa));

    TableLayout tableLayout;

    ArrayList<Flag> GameFlags = new ArrayList<>();

    int random;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        getSupportActionBar().setTitle("Matching Game");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findviews();


        startGame();

    }

    private void findviews() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressText = (TextView) findViewById(R.id.progresstext);
        countryName = (TextView) findViewById(R.id.textcountry);
    }

    private void startGame() {
        for (int i = 0; i < AFRICA.AfricanLongName.length; i++) {

            Flag flag = new Flag(AFRICA.AfricanLongName[i], AFRICA.Africa[i]);

            GameFlags.add(flag);
        }
        Collections.shuffle(GameFlags);
        drawGrid(3, 3);
        play();
        progress();
    }

    private void progress() {
        mProgress = 0;
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
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        else if (id == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    private void drawGrid(int n, int m) {
        tableLayout = (TableLayout) findViewById(R.id.TableGrid);
        int count = 0;
        for (int i = 0; i < n; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT

            ));

            tableLayout.addView(row);
            for (int j = 0; j < m; j++) {
                final int index = count;
                Button btn = new Button(this);

                btn.setBackgroundColor(getResources().getColor(R.color.transparent));

                btn.setBackgroundResource(GameFlags.get(index).getImagId());
                indexes.add(index);
                btn.setMinimumWidth(120);
                btn.setMinHeight(100);
                btn.setMaxHeight(100);
                btn.setMaxWidth(120);

                btn.setPadding(10, 10, 10, 10);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!array.contains(index))
                            checkClicked(index);
                    }
                });
                Buttons.add(btn);
                row.addView(btn);

                count++;
            }

        }


    }

    private void play() {

        if (indexes.size() == array.size())
            done();
        else
            do {
                random = rand.nextInt(indexes.size());
            } while (array.contains(random));
        Log.d("TAG", "play: random " + random);
        textView = GameFlags.get(random).getFlagName();
        countryName.setText(textView);


    }

    private void checkClicked(int index) {

//        Toast.makeText(this, "Button :  " + index + " Clicked", Toast.LENGTH_SHORT).show();
//        countryName.setText(GameFlags.get(index).getFlagName());
        Log.d("TAG", "checkClicked: " + index);

        if (GameFlags.get(index).getFlagName().equals(textView)) {
            correct(index);
            Buttons.get(index).setBackgroundColor(getResources().getColor(R.color.transparent));
            play();


        } else {
            wrong();
        }

    }

    private void wrong() {
        Toast.makeText(this, "Wrong ", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "wrong: ");
    }

    private void correct(int i) {
        //GameFlags.remove(random);
        array.add(i);
        Toast.makeText(this, "Correct ! ", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "correct: " + GameFlags.size());

    }

    private void done() {
        mProgressBar.setTop(mProgress);

        Toast.makeText(this, "Congrats ! in : " + mProgress, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onStop() {
        super.onStop();


    }
}



