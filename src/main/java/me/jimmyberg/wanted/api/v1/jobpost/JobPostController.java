package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.api.v1.jobpost.model.FindJobPostsRequest;
import me.jimmyberg.wanted.api.v1.jobpost.model.FindJobPostsResponse;
import me.jimmyberg.wanted.api.v1.jobpost.model.JobPostModel;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class JobPostController {

    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping("/job-posts")
    public FindJobPostsResponse findAll(@RequestBody FindJobPostsRequest request) {
        return jobPostService.findAll(request);
    }

    @GetMapping("/job-post/{id}")
    public JobPostModel findOne(@PathVariable long id) {
        return jobPostService.findOne(id);
    }

}
