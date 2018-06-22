package com.example.anselcorona2.projecttest.entities;

public class Address {

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
}
