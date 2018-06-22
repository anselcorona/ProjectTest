package com.example.anselcorona2.projecttest.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {

    private String Sector;
    private String Municipality;
    private String Province;
    private String Region;

    public Address(String sector, String municipality, String province, String region) {
        Sector = sector;
        Municipality = municipality;
        Province = province;
        Region = region;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getMunicipality() {
        return Municipality;
    }

    public void setMunicipality(String municipality) {
        Municipality = municipality;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    protected Address(Parcel in) {
        Sector = in.readString();
        Municipality = in.readString();
        Province = in.readString();
        Region = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Sector);
        dest.writeString(Municipality);
        dest.writeString(Province);
        dest.writeString(Region);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}