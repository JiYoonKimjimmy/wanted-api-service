package me.jimmyberg.wanted.common.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Locale {

    private String country;
    private String locality;
    private String region;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
