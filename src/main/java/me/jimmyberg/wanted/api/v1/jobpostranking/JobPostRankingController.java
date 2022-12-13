package me.jimmyberg.wanted.api.v1.jobpostranking;

import me.jimmyberg.wanted.api.v1.jobpostranking.model.JobPostRankingModel;
import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class JobPostRankingController {

    private final JobPostRankingService jobPostRankingService;

    public JobPostRankingController(JobPostRankingService jobPostRankingService) {
        this.jobPostRankingService = jobPostRankingService;
    }

    @GetMapping("/job-post/ranking")
    public List<JobPostRankingModel> findJobPostRanking(
        @RequestParam(required = false) JobPostRankingType type,
        @RequestParam(required = false, defaultValue = "3") int limit
    ) {
        return jobPostRankingService.findJobPostRanking(type, limit);
    }

}
