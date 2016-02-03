package com.apps.mounir.funwithflags;

/**
 * Created by mounir on 27.01.2016.
 */
public class Continents extends PlanetEarth {
    private String Name;
    private int ID;
    private String Story;

    public Continents() {

    }


    public Continents(String name, int id, String story) {
        Name = name;
        ID = id;
        Story = story;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStory() {
        return Story;
    }

    public void setStory(String story) {
        Story = story;
    }
}
