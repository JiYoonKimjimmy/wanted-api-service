package me.jimmyberg.wanted.api.v0.jobposting;

import me.jimmyberg.wanted.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, String> {
}
