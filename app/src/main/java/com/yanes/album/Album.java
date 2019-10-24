package com.yanes.album;

/**
 * Created by claud on 4/27/2018.
 */

public class Album {
    private String Name;
    private String Sport;
    private String Type;
    private String Class1;
    private String Info;
    private String Icon;
    Album() {
    }

    public Album(String name, String sport, String type, String class1, String info,String icon) {
        Name = name;
        Sport = sport;
        Type = type;
        Class1 = class1;
        Info = info;
        Icon = icon;
    }
    public String getIcon() {
        return Icon;
    }
    public String getName() { return Name; }
    public String getSport() {
        return Sport;
    }
    public String getType() {
        return Type;
    }
    public String getClass1() {
        return Class1;
    }
    public String getInfo() {
        return Info;
    }

    public void setIcon(String icon) {Icon = icon; }
    public void setName(String name) { Name = name;  }
    public void setSport(String sport) {
        Sport = sport;
    }
    public void setType(String type) {
        Type = type;
    }
    public void setClass1(String class1) {
        Class1 = class1;
    }
    public void setInfo(String info) {
        Info = info;
    }



    @Override
    public String toString() {
        return Icon + Name;
    }

}

