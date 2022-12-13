package me.jimmyberg.wanted.repository.jobpostranking;

import me.jimmyberg.wanted.entity.JobPostRanking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRankingRepository extends JpaRepository<JobPostRanking, Long>, JobPostRankingQRepository {

    List<JobPostRanking> findAllByRankerIn(List<String> rankers);

}
