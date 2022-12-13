package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.repository.jobpost.JobPostRepository;
import me.jimmyberg.wanted.api.v1.jobpost.model.FindJobPostsRequest;
import me.jimmyberg.wanted.api.v1.jobpost.model.FindJobPostsResponse;
import me.jimmyberg.wanted.api.v1.jobpost.model.JobPostModel;
import org.springframework.stereotype.Service;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public FindJobPostsResponse findAll(FindJobPostsRequest request) {
        return new FindJobPostsResponse(jobPostRepository.findAllBy(request).map(JobPostModel::of));
    }

    public JobPostModel findOne(long id) {
        return JobPostModel.of(jobPostRepository.findById(id).orElseThrow());
    }

}
