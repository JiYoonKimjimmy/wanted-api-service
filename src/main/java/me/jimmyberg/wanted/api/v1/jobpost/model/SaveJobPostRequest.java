package me.jimmyberg.wanted.api.v1.jobpost.model;

import io.swagger.v3.oas.annotations.media.Schema;
import me.jimmyberg.wanted.common.embeddable.Locale;

public class SaveJobPostRequest {

    @Schema(description = "기업 ID")
    private long companyId;
    @Schema(description = "직무")
    private String jobType;
    @Schema(description = "위치 정보")
    private Locale locale;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
