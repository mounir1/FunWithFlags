package com.apps.mounir.funwithflags;


/**
 * Created by mounir on 28.01.2016.
 */
public class Flag extends Country {

    private String Name;
    private int ImagId;
    private Country country;
    private com.apps.mounir.funwithflags.Continent continent;
    public boolean isCountry = true;
    private String IOStory;

    public Flag(String name, int img, Country country, com.apps.mounir.funwithflags.Continent continent) {

        this.Name = name;
        this.ImagId = img;
        this.country = country;
        this.continent = continent;
    }

    public Flag(String name, int img) {
        this.Name = name;
        this.ImagId = img;
    }

    public Flag(int ID, boolean iscountry) {
        this.ImagId = ID;
        this.isCountry = iscountry;
    }

    public Flag(String name, int ID, boolean isCountry, String Story) {
        this.Name = name;
        this.ImagId = ID;
        this.isCountry = isCountry;
        this.IOStory = Story;
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


    public String getCountry() {
        return super.getCountryName();
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public com.apps.mounir.funwithflags.Continent getContinent() {
        return this.continent;
    }

    public void setContinent(com.apps.mounir.funwithflags.Continent continent) {
        this.continent = continent;
    }

    public String getIOStory() {
        return IOStory;
    }

    public void setIOStory(String IOStory) {
        this.IOStory = IOStory;
    }
}