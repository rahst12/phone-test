package org.phone;

/**
 * Created by ryana on 4/11/2016.
 */
public class RegionCountry {
    String region;
    int country;

    public RegionCountry(int country, String region) {
        this.country = country;
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "RegionCountry{" +
                "region='" + region + '\'' +
                ", country=" + country +
                '}';
    }
}
