package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.api.v1.jobpost.model.GetJobPostsRequest;
import me.jimmyberg.wanted.api.v1.jobpost.model.GetJobPostsResponse;
import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class JobPostController {

    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping("/job-posts")
    public GetJobPostsResponse findAll(@RequestBody GetJobPostsRequest request) {
        return jobPostService.findAll(request);
    }

    @GetMapping("/job-post/{id}")
    public JobPost findOne(@PathVariable long id) {
        return jobPostService.findOne(id);
    }

}
