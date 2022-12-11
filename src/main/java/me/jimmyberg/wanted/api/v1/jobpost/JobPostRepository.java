package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
}
