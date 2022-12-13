package me.jimmyberg.wanted.api.v1.company.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class SaveCompanyResponse {

    @Schema(description = "기업 ID")
    private long id;

    public static SaveCompanyResponse of(long id) {
        SaveCompanyResponse response = new SaveCompanyResponse();
        response.setId(id);
        return response;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
