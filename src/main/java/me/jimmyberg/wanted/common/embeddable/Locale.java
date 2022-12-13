package me.jimmyberg.wanted.common.embeddable;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Embeddable;

@Embeddable
public class Locale {

    @Schema(description = "국가")
    private String country;
    @Schema(description = "소재지")
    private String locality;
    @Schema(description = "지역")
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
