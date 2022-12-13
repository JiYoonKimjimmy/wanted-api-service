package me.jimmyberg.wanted.api.v0.jobposting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class JobPostingController {

    private final JobPostingService jobPostingService;

    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/job-postings")
    public List<JobPosting> findAll() {
        return jobPostingService.findAll();
    }

    @GetMapping("/job-posting/{id}")
    public JobPosting findOne(@PathVariable String id) {
        return jobPostingService.findOne(id);
    }

}
