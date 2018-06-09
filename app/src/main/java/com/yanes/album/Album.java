package com.yanes.album;

/**
 * Created by claud on 4/27/2018.
 */

public class Album {
    private String State;
    private String Type;
    private String Name;
    private String Description;
    private String Photo;

    Album() {
    }

    public Album(String state, String type, String name, String description, String photo) {
        Name = name;
        State = state;
        Type = type;
        Description = description;
        Photo = photo;
    }
    public String getState() {
        return State;
    }

    public String getType() {
        return Type;
    }
    public String getName() { return Name; }

    public String getDescription() {
        return Description;
    }
    public String getPhoto() {
        return Photo;
    }
    public void setState(String state) {
        State = state;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setName(String name) { Name = name;  }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }



    @Override
    public String toString() {
        return Name;
    }

}

