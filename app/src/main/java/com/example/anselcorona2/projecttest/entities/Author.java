package com.example.anselcorona2.projecttest.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Author implements Parcelable {
    private String Name;
    private String Level;
    private String Location;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Author(String name, String level, String location) {

        Name = name;
        Level = level;
        Location = location;
    }

    protected Author(Parcel in) {
        Name = in.readString();
        Level = in.readString();
        Location = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Level);
        dest.writeString(Location);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Author> CREATOR = new Parcelable.Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };
}