package com.apps.mounir.funwithflags.Resources;

/**
 * Created by mounir on 27.01.2016.
 */
public class Continent extends PlanetEarth {
    private String Name;
    private int ID;
    private String Story;

    public Continent() {

    }


    public Continent(String name, int id, String story) {
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
