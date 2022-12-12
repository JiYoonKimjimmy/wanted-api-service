package me.jimmyberg.wanted.api.v1.jobpost.model;

import me.jimmyberg.wanted.entity.JobPost;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobPostModel {

    private long id;
    private String companyName;
    private String jobType;
    private String locale;
    private LocalDateTime posted;

    public JobPostModel() {
    }

    public static JobPostModel of(JobPost jobPost) {
        JobPostModel model = new JobPostModel();
        model.setId(jobPost.getId());
        model.setCompanyName(jobPost.getCompany().getName());
        model.setJobType(jobPost.getJobType());
        model.setLocale(jobPost);
        model.setPosted(jobPost.getPosted());
        return model;
    }

    private void setLocale(JobPost jobPost) {
        this.locale = Stream
                .of(jobPost.getCountry(), jobPost.getLocality(), jobPost.getRegion())
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

}
