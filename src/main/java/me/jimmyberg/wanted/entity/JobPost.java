package me.jimmyberg.wanted.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "JOB_POSTS")
@Entity
public class JobPost {

    @Id
    private long id;
    private String jobType;
    private String country;
    private String locality;
    private String region;
    private LocalDateTime posted;
    private LocalDateTime created;
    private LocalDateTime updated;

    @JoinColumn(name = "COMPANY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
