package me.jimmyberg.wanted.api.v1.jobpost;

import me.jimmyberg.wanted.api.v1.company.CompanyService;
import me.jimmyberg.wanted.api.v1.jobpost.model.*;
import me.jimmyberg.wanted.entity.Company;
import me.jimmyberg.wanted.entity.JobPost;
import me.jimmyberg.wanted.repository.jobpost.JobPostRepository;
import org.springframework.stereotype.Service;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    private final CompanyService companyService;

    public JobPostService(JobPostRepository jobPostRepository, CompanyService companyService) {
        this.jobPostRepository = jobPostRepository;
        this.companyService = companyService;
    }

    public SaveJobPostResponse save(SaveJobPostRequest request) {
        Company company = companyService.findById(request.getCompanyId()).orElseThrow();
        JobPost jobPost = jobPostRepository.save(new JobPost(request, company));
        return new SaveJobPostResponse(jobPost.getId());
    }

    public FindJobPostsResponse findAll(FindJobPostsRequest request) {
        return new FindJobPostsResponse(jobPostRepository.findAllBy(request).map(JobPostModel::of));
    }

    public JobPostModel findOne(long id) {
        return JobPostModel.of(jobPostRepository.findById(id).orElseThrow());
    }

}
