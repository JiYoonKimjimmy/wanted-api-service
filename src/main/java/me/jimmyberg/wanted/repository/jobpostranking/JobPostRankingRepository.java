package me.jimmyberg.wanted.repository.jobpostranking;

import me.jimmyberg.wanted.entity.JobPostRanking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRankingRepository extends JpaRepository<JobPostRanking, Long>, JobPostRankingQRepository {
}
