package com.apps.mounir.funwithflags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


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
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
}
