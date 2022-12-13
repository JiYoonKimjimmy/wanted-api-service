package me.jimmyberg.wanted.api.v0.jobposting;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;

    public JobPostingService(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
    }

    public List<JobPosting> findAll() {
        return jobPostingRepository.findAll();
    }

    public JobPosting findOne(String id) {
        return jobPostingRepository.findById(id).orElseThrow();
    }

}
