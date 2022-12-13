package me.jimmyberg.wanted.repository.jobpost;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.jimmyberg.wanted.api.v1.jobpost.model.GetJobPostsRequest;
import me.jimmyberg.wanted.entity.JobPost;
import me.jimmyberg.wanted.entity.QJobPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface JobPostQRepository {

    Page<JobPost> findAllBy(GetJobPostsRequest request);

    class JobPostQRepositoryImpl implements JobPostQRepository {

        private final JPAQueryFactory jpaQueryFactory;

        public JobPostQRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
            this.jpaQueryFactory = jpaQueryFactory;
        }

        @Override
        public Page<JobPost> findAllBy(GetJobPostsRequest request) {
            QJobPost entity = QJobPost.jobPost;
            PageRequest pageable = request.getPageable().toPageRequest();

            List<JobPost> content = jpaQueryFactory
                    .selectFrom(entity)
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetch();

            Long count = jpaQueryFactory
                    .select(entity.count())
                    .from(entity)
                    .fetchOne();

            return new PageImpl<>(content, pageable, count == null ? 0 : count);
        }

    }
}
