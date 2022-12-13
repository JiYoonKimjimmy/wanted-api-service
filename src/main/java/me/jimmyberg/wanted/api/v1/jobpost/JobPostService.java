package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.repository.jobpost.JobPostRepository;
import me.jimmyberg.wanted.api.v1.jobpost.model.GetJobPostsRequest;
import me.jimmyberg.wanted.api.v1.jobpost.model.GetJobPostsResponse;
import me.jimmyberg.wanted.api.v1.jobpost.model.JobPostModel;
import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.stereotype.Service;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public GetJobPostsResponse findAll(GetJobPostsRequest request) {
        return new GetJobPostsResponse(jobPostRepository.findAllBy(request).map(JobPostModel::of));
    }

    public JobPost findOne(long id) {
        return jobPostRepository.findById(id).orElseThrow();
    }

}
