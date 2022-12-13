package me.jimmyberg.wanted.api.v1.jobpostranking;

import me.jimmyberg.wanted.api.v1.jobpostranking.model.JobPostRankingModel;
import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;
import me.jimmyberg.wanted.entity.JobPost;
import me.jimmyberg.wanted.entity.JobPostRanking;
import me.jimmyberg.wanted.repository.jobpostranking.JobPostRankingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostRankingService {

    private final JobPostRankingRepository jobPostRankingRepository;

    public JobPostRankingService(JobPostRankingRepository jobPostRankingRepository) {
        this.jobPostRankingRepository = jobPostRankingRepository;
    }

    /**
     * 공고 랭킹 정보 저장
     */
    @Transactional
    public List<JobPostRanking> count(JobPost jobPost) {
        return jobPostRankingRepository
            .findAllByRankerIn(jobPost.rankerIn())
            .stream()
            .map(JobPostRanking::count)
            .collect(Collectors.toList());
    }

    /**
     * 공고 랭킹 목록 조회
     */
    public List<JobPostRankingModel> findJobPostRanking(JobPostRankingType type, int limit) {
        List<JobPostRankingModel> result = new ArrayList<>();

        // type == null 인 경우, 전체 type 별 조회
        List<JobPostRankingType> types = (type == null) ? Arrays.asList(JobPostRankingType.values()) : List.of(type);
        for (JobPostRankingType value : types) {
            result.addAll(JobPostRankingModel.of(jobPostRankingRepository.findJobPostRanking(value, limit)));
        }

        return result;
    }

}
