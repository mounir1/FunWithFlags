package com.apps.mounir.funwithflags;

import android.widget.ImageButton;

/**
 * Created by mounir on 27.01.2016.
 */
public class Country extends Continents {

    private String Name;
    private String Continent;
    private Flag flagImage;
    private String Currency;
    private String Religion;


    public Country() {

    }

    public Country(String name) {
        this.Name = name;
    }

    public Country(String name, String Continent, Flag flag, String currency, String relgion) {
        this.Name = name;
        this.Continent = Continent;
        this.flagImage = flag;
        this.Currency = currency;
        this.Religion = relgion;

    }

    public Country(String name, int id) {
        this.Name = name;
        this.flagImage = new Flag(name, id);
    }

    public Country(String name, Flag flag, String currency, String relgion) {
        this.Name = name;
        this.flagImage = flag;
        this.Currency = currency;
        this.Religion = relgion;
    }


    public String getCountryName() {
        return Name;
    }


    public void setCountryName(String name) {
        Name = name;
    }


    public Flag getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(Flag flagImage) {
        this.flagImage = flagImage;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }
}
