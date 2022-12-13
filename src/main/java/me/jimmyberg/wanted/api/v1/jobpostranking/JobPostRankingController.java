package me.jimmyberg.wanted.api.v1.jobpostranking;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jimmyberg.wanted.api.v1.jobpostranking.model.JobPostRankingModel;
import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Job Post Ranking APIs")
@RequestMapping("/api/v1")
@RestController
public class JobPostRankingController {

    private final JobPostRankingService jobPostRankingService;

    public JobPostRankingController(JobPostRankingService jobPostRankingService) {
        this.jobPostRankingService = jobPostRankingService;
    }

    @Operation(summary = "공고 랭킹 정보 조회 API")
    @GetMapping("/job-post/ranking")
    public List<JobPostRankingModel> findJobPostRanking(
        @RequestParam(required = false) JobPostRankingType type,
        @RequestParam(required = false, defaultValue = "3") int limit
    ) {
        return jobPostRankingService.findJobPostRanking(type, limit);
    }

}
