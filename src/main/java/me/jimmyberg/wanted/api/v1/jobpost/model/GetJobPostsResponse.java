package me.jimmyberg.wanted.api.v1.jobpost.model;

import me.jimmyberg.wanted.api.common.model.PageableResponse;
import org.springframework.data.domain.Page;

public class GetJobPostsResponse extends PageableResponse<JobPostModel> {

    public GetJobPostsResponse(Page<JobPostModel> pageable) {
        super(pageable);
    }

}
