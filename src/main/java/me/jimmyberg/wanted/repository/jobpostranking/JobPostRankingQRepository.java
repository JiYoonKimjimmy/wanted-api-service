package me.jimmyberg.wanted.repository.jobpostranking;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;
import me.jimmyberg.wanted.entity.JobPostRanking;

import java.util.List;

import static me.jimmyberg.wanted.entity.QJobPostRanking.jobPostRanking;

public interface JobPostRankingQRepository {

    List<JobPostRanking> findJobPostRanking(JobPostRankingType type, int limit);

    class JobPostRankingQRepositoryImpl implements JobPostRankingQRepository {

        private final JPAQueryFactory jpaQueryFactory;

        public JobPostRankingQRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
            this.jpaQueryFactory = jpaQueryFactory;
        }

        @Override
        public List<JobPostRanking> findJobPostRanking(JobPostRankingType type, int limit) {
            return jpaQueryFactory
                    .selectFrom(jobPostRanking)
                    .where(jobPostRanking.type.eq(type))
                    .orderBy(jobPostRanking.count.desc())
                    .limit(limit)
                    .fetch();
        }
    }

}
