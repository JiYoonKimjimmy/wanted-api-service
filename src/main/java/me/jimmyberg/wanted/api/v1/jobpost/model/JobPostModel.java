package me.jimmyberg.wanted.api.v1.jobpost.model;

import io.swagger.v3.oas.annotations.media.Schema;
import me.jimmyberg.wanted.entity.JobPost;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobPostModel {

    @Schema(description = "기업 ID")
    private long id;
    @Schema(description = "기업명")
    private String companyName;
    @Schema(description = "직무")
    private String jobType;
    @Schema(description = "위치 정보")
    private String locale;
    @Schema(description = "공고 등록 일자")
    private LocalDateTime posted;

    public static JobPostModel of(JobPost entity) {
        JobPostModel model = new JobPostModel();
        model.setId(entity.getId());
        model.setCompanyName(entity.getCompany().getName());
        model.setJobType(entity.getJobType());
        model.setLocale(entity);
        model.setPosted(entity.getPosted());
        return model;
    }

    private void setLocale(JobPost jobPost) {
        this.locale = Stream
                .of(jobPost.getLocale().getCountry(), jobPost.getLocale().getLocality(), jobPost.getLocale().getRegion())
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
