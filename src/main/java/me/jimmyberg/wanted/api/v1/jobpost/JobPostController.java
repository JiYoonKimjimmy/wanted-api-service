package me.jimmyberg.wanted.api.v1.jobpost;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jimmyberg.wanted.api.v1.jobpost.model.*;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Job Post APIs")
@RequestMapping("/api/v1")
@RestController
public class JobPostController {

    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @Operation(summary = "공고 등록 API")
    @PostMapping("/job-post")
    public SaveJobPostResponse save(@RequestBody SaveJobPostRequest request) {
        return jobPostService.save(request);
    }

    @Operation(summary = "공고 목록 조회 API")
    @PostMapping("/job-posts")
    public FindJobPostsResponse findAll(@RequestBody FindJobPostsRequest request) {
        return jobPostService.findAll(request);
    }

    @Operation(summary = "공고 단건 조회 API")
    @GetMapping("/job-post/{id}")
    public JobPostModel findOne(@PathVariable long id) {
        return jobPostService.findOne(id);
    }

}
