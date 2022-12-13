package me.jimmyberg.wanted.api.v1.jobpost.model;

public class SaveJobPostResponse {

    private long id;

    public SaveJobPostResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
