package com.apps.mounir.funwithflags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public class FlagList extends AppCompatActivity {
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flaglist);
        type = getIntent().getStringExtra(MainActivity.Extra);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, MainFragment.newInstance(type)).commit();

            getSupportActionBar().setTitle(type);
        }
    }
}
