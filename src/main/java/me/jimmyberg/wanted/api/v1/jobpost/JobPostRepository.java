package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Long>, JobPostQRepository {
}
