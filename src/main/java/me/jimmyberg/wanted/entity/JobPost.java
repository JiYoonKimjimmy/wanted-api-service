package me.jimmyberg.wanted.entity;

import me.jimmyberg.wanted.api.v1.jobpost.model.SaveJobPostRequest;
import me.jimmyberg.wanted.common.embeddable.Locale;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "JOB_POSTS")
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String jobType;
    @Embedded
    private Locale locale;
    private LocalDateTime posted;
    private LocalDateTime created;
    private LocalDateTime updated;

    @JoinColumn(name = "COMPANY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    public JobPost() {
    }

    public JobPost(SaveJobPostRequest request, Company company) {
        this.jobType = request.getJobType();
        this.locale = request.getLocale();
        this.company = company;
        this.posted = LocalDateTime.now();
    }

    /**
     * Repository 조회하기 위한 ranker in 절 parameter 생성
     */
    public List<String> rankerIn() {
        List<String> rankerIn = new ArrayList<>();
        if (this.company.getName() != null) rankerIn.add(this.company.getName());
        if (this.locale.getCountry() != null) rankerIn.add(this.locale.getCountry());
        return rankerIn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

}
