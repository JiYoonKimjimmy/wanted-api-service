package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class JobPostController {

    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/job-posts")
    public List<JobPost> findAll() {
        return jobPostService.findAll();
    }

    @GetMapping("/job-post/{id}")
    public JobPost findOne(@PathVariable long id) {
        return jobPostService.findOne(id);
    }

}
