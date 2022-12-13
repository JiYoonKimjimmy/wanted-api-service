package me.jimmyberg.wanted.api.v1.company.model;

import io.swagger.v3.oas.annotations.media.Schema;
import me.jimmyberg.wanted.common.embeddable.Locale;

public class SaveCompanyRequest {

    @Schema(description = "기업명")
    private String name;
    @Schema(description = "위치 정보")
    private Locale locale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
