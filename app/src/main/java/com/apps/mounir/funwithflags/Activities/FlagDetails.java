package com.apps.mounir.funwithflags.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.mounir.funwithflags.Resources.AFRICA;
import com.apps.mounir.funwithflags.Resources.ASIA;
import com.apps.mounir.funwithflags.Resources.EUROPE;
import com.apps.mounir.funwithflags.Helpers.Flag;
import com.apps.mounir.funwithflags.Helpers.MainFragment;
import com.apps.mounir.funwithflags.Resources.NAmerica;
import com.apps.mounir.funwithflags.Resources.Oceana;
import com.apps.mounir.funwithflags.R;
import com.apps.mounir.funwithflags.Resources.SouthAmerica;
import com.apps.mounir.funwithflags.Helpers.ViewHolder;

import java.util.ArrayList;

public class FlagDetails extends AppCompatActivity {


    TextView Continent, CountryName, CapitalCity, Region, Population, Currency, Area, Religion, Code, IOName, story;
    ImageView FlagImage, FlagIoImage;


    ArrayList<Flag> Flags = MainFragment.FLAGS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int ImageID = Integer.parseInt(getIntent().getStringExtra(ViewHolder.ImageID));

        int index;
        Log.d("1 Debug ", "duging");
        for (Flag flag : Flags) {
            if (flag.getImagId() == ImageID) {
                if (!flag.isCountry) {
                    Log.d("2 Debug ", "duging _ is no t country ");
                    setContentView(R.layout.iodetails);
                    Log.d("2 Debug ", "duging _ is no t country ");
                    FlagIoImage = (ImageView) findViewById(R.id.IOFlag);
                    Log.d("2 Debug ", "duging _ is no t country ");
                    IOName = (TextView) findViewById(R.id.IOname);
                    Log.d("2 Debug ", "duging _ is no t country ");
                    story = (TextView) findViewById(R.id.story_de);
                    Log.d("2 Debug ", "duging _ is no t country ");

                    FlagIoImage.setImageResource(ImageID);
                    Log.d("2 Debug ", "duging _ is no t country ");
                    IOName.setText(flag.getFlagName());
                    Log.d("2 Debug ", "duging _ is no t country ");
                    story.setText(flag.getIOStory());
                    Log.d("2 Debug ", "duging _ is no t country ");


                } else {
                    if (flag.getContinent().getName() != null) {
                        setContentView(R.layout.flag_details);
                        Continent = (TextView) findViewById(R.id.continentname);
                        CountryName = (TextView) findViewById(R.id.Country_nom);
                        FlagImage = (ImageView) findViewById(R.id.imageView2);
                        CapitalCity = (TextView) findViewById(R.id.city);
                        Region = (TextView) findViewById(R.id.region_de);
                        Currency = (TextView) findViewById(R.id.currency);
                        Area = (TextView) findViewById(R.id.area_de);
                        Code = (TextView) findViewById(R.id.phone_de);
                        Continent.setText(flag.getContinent().getName());
                        switch (flag.getContinent().getID()) {
                            case 1:
                                index = getindex(ImageID, AFRICA.Africa);

                                if (index == -1) { //wrong continent ! wrond index
                                    setElementsDoesntExist();
                                } else {
                                    printAfr(index);
                                }
                                break;
                            case 2:
                                index = getindex(ImageID, EUROPE.Europe);

                                if (index == -1) { //wrong continent ! wrond index
                                    setElementsDoesntExist();
                                } else {
                                    Log.d(" 1 Debug ", "printEup  " + index + " flag.getContinent().getID()" + flag.getContinent().getID());
                                    printEup(index);
                                }
                                break;
                            case 3:
                                index = getindex(ImageID, ASIA.Asia);

                                if (index == -1) { //wrong continent ! wrond index
                                    setElementsDoesntExist();
                                } else {
                                    Log.d(" 1 Debug ", "printEup  " + index + " flag.getContinent().getID()" + flag.getContinent().getID());
                                    printAsia(index);
                                }
                                break;
                            case 4:
                                index = getindex(ImageID, NAmerica.NAmerica);

                                if (index == -1) { //wrong continent ! wrond index
                                    setElementsDoesntExist();
                                } else {
                                    Log.d(" 1 Debug ", "printEup  " + index + " flag.getContinent().getID()" + flag.getContinent().getID());
                                    printNamerica(index);
                                }
                                break;
                            case 5:
                                index = getindex(ImageID, SouthAmerica.SAmerica);
                                if (index == -1) { //wrong continent ! wrond index
                                    setElementsDoesntExist();
                                } else {
                                    Log.d(" 1 Debug ", "printEup  " + index + " flag.getContinent().getID()" + flag.getContinent().getID());
                                    printsamerica(index);
                                }
                                break;
                            case 6:
                                index = getindex(ImageID, Oceana.Oceana);
                                if (index == -1) { //wrong continent ! wrond index
                                    setElementsDoesntExist();
                                } else {
                                    Log.d(" 1 Debug ", "printEup  " + index + " flag.getContinent().getID()" + flag.getContinent().getID());
                                    printsoceana(index);
                                }
                                break;
                        }

                        break;
                    }
                    Toast.makeText(this, "this Flag either has got No details or you better check in its relevant continents submenu", Toast.LENGTH_LONG).show();
                    break;
                }
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

    private void printsoceana(int index) {
        CountryName.setText(Oceana.Names[index].trim());

        FlagImage.setImageResource(Oceana.Oceana[index]);

        CapitalCity.setText(Oceana.capitals[index].trim());

        Currency.setText(Oceana.Currencies[index]);

        Area.setText(String.valueOf(Oceana.Areas[index]).trim() + " km²");

        Code.setText("+" + Oceana.phonecodes[index]);

        Region.setText("Not Known ");
    }

    private void printsamerica(int index) {
        CountryName.setText(SouthAmerica.Countries[index].trim());

        FlagImage.setImageResource(SouthAmerica.SAmerica[index]);

        CapitalCity.setText(SouthAmerica.Capitals[index].trim());

        Currency.setText(SouthAmerica.Currencies[index]);

        Area.setText(String.valueOf(SouthAmerica.SamArea[index]).trim() + " km²");

        Code.setText("+" + SouthAmerica.Phonecode[index]);

        Region.setText("Not Known ");
    }

    private void printNamerica(int index) {

        CountryName.setText(NAmerica.Namescountries[index].trim());

        FlagImage.setImageResource(NAmerica.NAmerica[index]);

        CapitalCity.setText(NAmerica.CapitalCities[index].trim());

        Currency.setText(NAmerica.Currencies[index]);

        Area.setText(String.valueOf(NAmerica.Areas[index]).trim() + " km²");

        Code.setText("+" + NAmerica.phonecodes[index]);

        Region.setText("Not Known ");

    }

    private void printAsia(int index) {

        CountryName.setText(ASIA.Names[index].trim());

        FlagImage.setImageResource(ASIA.Asia[index]);

        CapitalCity.setText(ASIA.CApitals[index].trim());

        Currency.setText(ASIA.Currencies[index]);

        Area.setText(String.valueOf(ASIA.Areas[index]).trim() + " km²");

        Code.setText("+" + ASIA.phonecodes[index]);

        Region.setText("Not Known ");

    }

    private void printAfr(int index) {

        CountryName.setText(AFRICA.AfricanLongName[index].trim());
        Log.d("1 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        FlagImage.setImageResource(AFRICA.Africa[index]);
        Log.d("2 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        CapitalCity.setText(AFRICA.AfricanCapitalCities[index].trim());

        Region.setText(AFRICA.Region(AFRICA.Region[index]));

        Currency.setText(AFRICA.AfricanCurrencies[index].trim() + " " + AFRICA.AfricanISO[index].trim());

        Area.setText(AFRICA.AfricanArea[index] + " km²");

        Code.setText("+" + String.valueOf(AFRICA.Phonecode[index]));

    }


    private void printEup(int index) {

        CountryName.setText(EUROPE.EuropeanNames[index].trim());
        Log.d("2 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        FlagImage.setImageResource(EUROPE.Europe[index]);
        Log.d("3 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        CapitalCity.setText(EUROPE.CapitalCities[index].trim());
        Log.d("4 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        Currency.setText(EUROPE.EuCurrencies[index]);
        Log.d("5 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        Area.setText(EUROPE.EurupeArea[index].trim() + " km²");
        Log.d("6 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        Code.setText(String.valueOf(EUROPE.PhoneCodes[index]).trim());
        Log.d("7 Debug ", "printEup  " + index + " flag.getContinent().getID()");
        Region.setText("Not Known ");

    }

    private void setElementsDoesntExist() {
    }

    private int getindex(int ImagId, int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (ImagId == list[i]) {
                return i;
            }
        }
        return -1;
    }
}
