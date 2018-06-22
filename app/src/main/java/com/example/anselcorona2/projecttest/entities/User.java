package com.example.anselcorona2.projecttest.entities;

import java.util.Date;

public class User {

    private String ID;
    private String Names;
    private String Surnames;
    private Date Birth;
    private String Facebook;
    private String Instagram;
    private String Twitter;
    private Address address;

    public User(String ID, String names, String surnames, Date birth, String facebook, String instagram, String twitter, Address address) {
        this.ID = ID;
        Names = names;
        Surnames = surnames;
        Birth = birth;
        Facebook = facebook;
        Instagram = instagram;
        Twitter = twitter;
        this.address = address;
    }

    public User() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getSurnames() {
        return Surnames;
    }

    public void setSurnames(String surnames) {
        Surnames = surnames;
    }

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date birth) {
        Birth = birth;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
