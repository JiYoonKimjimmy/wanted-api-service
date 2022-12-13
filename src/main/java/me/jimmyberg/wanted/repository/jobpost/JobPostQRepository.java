package me.jimmyberg.wanted.repository.jobpost;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.jimmyberg.wanted.api.v1.jobpost.model.FindJobPostsRequest;
import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static me.jimmyberg.wanted.entity.QJobPost.jobPost;

public interface JobPostQRepository {

    Page<JobPost> findAllBy(FindJobPostsRequest request);

    class JobPostQRepositoryImpl implements JobPostQRepository {

        private final JPAQueryFactory jpaQueryFactory;

        public JobPostQRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
            this.jpaQueryFactory = jpaQueryFactory;
        }

        @Override
        public Page<JobPost> findAllBy(FindJobPostsRequest request) {
            PageRequest pageRequest = request.pageRequest();

            List<JobPost> content = jpaQueryFactory
                    .selectFrom(jobPost)
                    .where(request.generateWhere())
                    .orderBy(request.orderBy(jobPost))
                    .offset(pageRequest.getOffset())
                    .limit(pageRequest.getPageSize())
                    .fetch();

            Long count = jpaQueryFactory
                    .select(jobPost.count())
                    .from(jobPost)
                    .fetchOne();

            return new PageImpl<>(content, pageRequest, count == null ? 0 : count);
        }

    }

}
