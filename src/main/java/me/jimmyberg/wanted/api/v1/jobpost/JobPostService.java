package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.api.v1.company.CompanyService;
import me.jimmyberg.wanted.api.v1.jobpost.model.*;
import me.jimmyberg.wanted.api.v1.jobpostranking.JobPostRankingService;
import me.jimmyberg.wanted.entity.Company;
import me.jimmyberg.wanted.entity.JobPost;
import me.jimmyberg.wanted.repository.jobpost.JobPostRepository;
import org.springframework.stereotype.Service;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    private final CompanyService companyService;
    private final JobPostRankingService jobPostRankingService;

    public JobPostService(JobPostRepository jobPostRepository, CompanyService companyService, JobPostRankingService jobPostRankingService) {
        this.jobPostRepository = jobPostRepository;
        this.companyService = companyService;
        this.jobPostRankingService = jobPostRankingService;
    }

    /**
     * 공고 저장
     */
    public SaveJobPostResponse save(SaveJobPostRequest request) {
        Company company = companyService.findById(request.getCompanyId()).orElseThrow();
        JobPost jobPost = jobPostRepository.save(new JobPost(request, company));

        // job post ranking count 증가 처리
        jobPostRankingService.count(jobPost);

        return new SaveJobPostResponse(jobPost.getId());
    }

    /**
     * 공고 목록 조회
     */
    public FindJobPostsResponse findAll(FindJobPostsRequest request) {
        return new FindJobPostsResponse(jobPostRepository.findAllBy(request).map(JobPostModel::of));
    }

    /**
     * 공고 단건 조회
     */
    public JobPostModel findOne(long id) {
        return JobPostModel.of(jobPostRepository.findById(id).orElseThrow());
    }

}
