package me.jimmyberg.wanted.api.v1.jobpost.model;

import me.jimmyberg.wanted.common.model.PageableResponse;
import org.springframework.data.domain.Page;

public class FindJobPostsResponse extends PageableResponse<JobPostModel> {

    public FindJobPostsResponse(Page<JobPostModel> pageable) {
        super(pageable);
    }

}
