package me.jimmyberg.wanted.api.v1.jobpost.model;

import me.jimmyberg.wanted.common.model.PageableRequest;

public class GetJobPostsRequest {

    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }

}
