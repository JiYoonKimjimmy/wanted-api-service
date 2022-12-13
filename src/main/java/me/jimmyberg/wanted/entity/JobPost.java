package me.jimmyberg.wanted.entity;

import me.jimmyberg.wanted.api.v1.jobpost.model.SaveJobPostRequest;
import me.jimmyberg.wanted.common.embeddable.Locale;
import me.jimmyberg.wanted.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "JOB_POSTS")
@Entity
public class JobPost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String jobType;
    @Embedded
    private Locale locale;
    private LocalDateTime posted;

    @JoinColumn(name = "COMPANY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    public static JobPost of(SaveJobPostRequest request, Company company) {
        JobPost entity = new JobPost();
        entity.setJobType(request.getJobType());
        entity.setLocale(request.getLocale());
        entity.setCompany(company);
        entity.setPosted(LocalDateTime.now());
        return entity;
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

}
