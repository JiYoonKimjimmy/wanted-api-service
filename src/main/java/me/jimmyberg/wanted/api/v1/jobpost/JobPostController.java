package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.api.v1.jobpost.model.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class JobPostController {

    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping("/job-post")
    public SaveJobPostResponse save(@RequestBody SaveJobPostRequest request) {
        return jobPostService.save(request);
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
