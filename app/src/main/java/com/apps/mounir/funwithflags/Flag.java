package com.apps.mounir.funwithflags;


//import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.Sources.Country;

/**
 * Created by mounir on 28.01.2016.
 */
public class Flag  {

    private String Name;
    private int ImagId;
    private Country country;
    private Continents continent;

    public Flag(String name, int img, Country country, Continents continent) {

        this.Name = name;
        this.ImagId = img;
        this.country = country;
        this.continent = continent;
    }

    public Flag(String name, int img) {
        this.Name = name;
        this.ImagId = img;
    }


    public String getFlagName() {
        return Name;
    }

    public void setFlagName(String name) {
        this.Name = name;
    }

    public int getImagId() {
        return this.ImagId;
    }

    public void setImagId(int imagId) {
        ImagId = imagId;
    }


}