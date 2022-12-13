package me.jimmyberg.wanted.repository.jobpost;

import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Long>, JobPostQRepository {
}
