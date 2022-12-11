package me.jimmyberg.wanted.api.v1.jobpost.model;

import me.jimmyberg.wanted.api.common.model.PageableResponse;
import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.data.domain.Page;

public class GetJobPostsResponse extends PageableResponse<JobPost> {

    public GetJobPostsResponse(Page<JobPost> pageable) {
        super(pageable);
    }

    public static GetJobPostsResponse of(Page<JobPost> pageable) {
        return new GetJobPostsResponse(pageable);
    }

}
