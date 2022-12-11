package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public List<JobPost> findAll() {
        return jobPostRepository.findAll();
    }

    public JobPost findOne(long id) {
        return jobPostRepository.findById(id).orElseThrow();
    }

}
