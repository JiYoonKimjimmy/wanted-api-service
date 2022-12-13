package me.jimmyberg.wanted.api.v1.jobpostranking;

import me.jimmyberg.wanted.api.v1.jobpostranking.model.JobPostRankingModel;
import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;
import me.jimmyberg.wanted.repository.jobpostranking.JobPostRankingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostRankingService {

    private final JobPostRankingRepository jobPostRankingRepository;

    public JobPostRankingService(JobPostRankingRepository jobPostRankingRepository) {
        this.jobPostRankingRepository = jobPostRankingRepository;
    }

    public List<JobPostRankingModel> findJobPostRanking(JobPostRankingType type, int limit) {
        List<JobPostRankingModel> result = new ArrayList<>();

        if (type == null) {
            // 전체 조회인 경우
            for (JobPostRankingType value : JobPostRankingType.values()) {
                result.addAll(JobPostRankingModel.of(jobPostRankingRepository.findJobPostRanking(value, limit)));
            }
        } else {
            result.addAll(JobPostRankingModel.of(jobPostRankingRepository.findJobPostRanking(type, limit)));
        }

        return result;
    }

}
