package me.jimmyberg.wanted.api.v1.jobpost.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class SaveJobPostResponse {

    @Schema(description = "공고 ID")
    private long id;

    public static SaveJobPostResponse of(long id) {
        SaveJobPostResponse response = new SaveJobPostResponse();
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
