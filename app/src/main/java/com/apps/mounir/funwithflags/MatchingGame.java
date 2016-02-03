package com.apps.mounir.funwithflags;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by mac on 21/01/16.
 */
public class MatchingGame extends AppCompatActivity {


    //ArrayList allFlagsIds = FlagsList.FlagIds;
    TextView CountryName;
    int[] FlagsOfTheGame = {R.drawable._algeria, R.drawable._french_southern_territories, R.drawable._saint_barthelemy, R.drawable._western_sahara,
            R.drawable._bolivarian_alliance_for_the_peoples_of_our_america, R.drawable._jamaica, R.drawable._haiti, R.drawable._laos};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MatchingHandler", "Success1");
        setContentView(R.layout.matchinggame);
        //Resources res = getResources();
        Log.d("MatchingHandler", "Success2");
        //String Difficulty = getIntent().getStringExtra(Matching.DIFFICULTY);
        Log.d("MatchingHandler", "Success3");
        //CountryName = (TextView) findViewById(R.id.CountryName);
        Log.d("MatchingHandler", "Success4");
        //FlagsList.setAllFlags();
        //Collections.shuffle(allFlagsIds);
        //FrameLayout framlayout = (FrameLayout) findViewById(R.id.framelayout);
        //Button btn = new Button(this);

        ////btn.setText("Easy Mode");
        //btn.setHeight(40);

        //framlayout.addView(btn);
        //ArrayList<Integer> FlagstoMatch = (ArrayList) allFlagsIds.subList(0, 12);

       // ImageButton imbtn = new ImageButton(this);
       // GridLayout grid = (GridLayout) findViewById(R.id.myGrid);

        //for (int i = 0; i < FlagsOfTheGame.length; i++) {
        //    imbtn.setTag(FlagsOfTheGame[i]);
         //   grid.addView(imbtn);

      //  }
   // StartGame();
    }




    void StartGame(){


    }

    public void mathHandler(View view) {


    }
}
