package com.apps.mounir.funwithflags;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mac on 21/01/16.
 */
public class MatchingGame extends Activity {


    // Declare variables / references
    private GridView gv;
    private Animator mCurrentAnimator;
    private int mShortAnimationDuration;
    GridView layout;
    // Create Array thumbs resource id's:
    private int thumb[] = {R.drawable._algeria, R.drawable._french_southern_territories, R.drawable._saint_barthelemy, R.drawable._western_sahara,
            R.drawable._bolivarian_alliance_for_the_peoples_of_our_america, R.drawable._jamaica, R.drawable._haiti, R.drawable._laos};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchgame);
        Log.d("onCreate", "set Contenet");

        layout = (GridView) findViewById(R.id.gridview);
        for (int i = 0; i < 10; i++) {
            ImageView image = new ImageView(this);
            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(80, 60));
            image.setImageResource(thumb[i]);
            image.setMaxHeight(20);
            image.setMaxWidth(20);
            Log.d("Tag", "onCreate: ");
            // Adds the view to the layout
            layout.addView(image);
        }
    }

}



/*

ArrayList FlagsIds = MainFragment.FLAGS; //recently viewd
    ArrayList<Integer> IDS = MainFragment.FlagIds;

    private Animator currentanimator;
    public static ArrayList<Integer> ListofFlags = new ArrayList<>();
    private Random randomGenerator;

    private ArrayList<Integer> catalogue;
    private ArrayList<ImageButton> Buttons = new ArrayList<>();

    TextView CountryName;
    ImageButton imgb1, imgb2, imgb3, imgb4, imgb5, imgb6, imgb7, imgb8, imgb9, imgb10, imgb11, imgb12, imgb13, imgb14, imgb15, imgb16, imgb17, imgb18;

    int[] FlagsOfTheGame = {R.drawable._algeria, R.drawable._french_southern_territories, R.drawable._saint_barthelemy, R.drawable._western_sahara,
            R.drawable._bolivarian_alliance_for_the_peoples_of_our_america, R.drawable._jamaica, R.drawable._haiti, R.drawable._laos};

    private GridView grid;

    public MatchingGame() {
        catalogue = new ArrayList<Integer>();
        randomGenerator = new Random();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchgame);
        init(12);
        grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                zoomImage(view, FlagsOfTheGame[position]);
            }

        });


        MainFragment.getAllFlagNames();
        //Resources res = getResources();
        Log.d("MatchingHandler", "Success2");
        String Difficulty = getIntent().getStringExtra(Matching.DIFFICULTY);
        Log.d("MatchingHandler", "Success3");
        CountryName = (TextView) findViewById(R.id.CountryName);
        Log.d("MatchingHandler", "Success4");


        StartGame();
    }

    private void zoomImage(final View view, int i) {

        if (currentanimator != null)
            currentanimator.cancel();
        final ImageView expanded = (ImageView) findViewById(R.id.picture_grid);
        expanded.setImageResource(i);
    }


    private void init(int n) {

        imgb1 = (ImageButton) findViewById(R.id.imageB1);
        imgb2 = (ImageButton) findViewById(R.id.imageB2);
        imgb3 = (ImageButton) findViewById(R.id.imageB3);
        imgb4 = (ImageButton) findViewById(R.id.imageB4);
        imgb5 = (ImageButton) findViewById(R.id.imageB5);
        imgb6 = (ImageButton) findViewById(R.id.imageB6);
        imgb7 = (ImageButton) findViewById(R.id.imageB7);
        imgb8 = (ImageButton) findViewById(R.id.imageB8);
        imgb9 = (ImageButton) findViewById(R.id.imageB9);
        imgb10 = (ImageButton) findViewById(R.id.imageB10);
        imgb11 = (ImageButton) findViewById(R.id.imageB11);
        imgb12 = (ImageButton) findViewById(R.id.imageB12);
//        for (int i = 0; i <n ; i++) {
//            Buttons.add(imgb1);
//            Buttons.add(imgb2);
//
//        }
//        imgb1 = (ImageButton) findViewById(R.id.imageB13);
//        imgb1 = (ImageButton) findViewById(R.id.imageB14);
//        imgb1 = (ImageButton) findViewById(R.id.imageB15);


    }


    void StartGame() {
        makeagrid();

    }

    private void makeagrid() {
        for (int i = 0; i < FlagsOfTheGame.length; i++) {
            imgb1.setImageResource((IDS.get(randomGenerator.nextInt(IDS.size()))));

        }
    }

    public void mathHandler(View view) {


    }

    class ImageAdapter extends BaseAdapter implements ListAdapter {
        private LayoutInflater inflater;

        public ImageAdapter(MatchingGame matchingGame) {
            inflater = (LayoutInflater) matchingGame.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return FlagsOfTheGame.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View list = convertView;
            int pos = position;
            if (list == null)
                list = inflater.inflate(R.layout.grid, null);
            ImageView iv = (ImageView) list.findViewById(R.id.picture_grid);
            iv.setBackgroundResource(FlagsOfTheGame[pos]);


            return list;
        }


    }
 */