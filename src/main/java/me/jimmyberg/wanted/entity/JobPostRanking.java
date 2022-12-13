package me.jimmyberg.wanted.entity;

import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "JOB_POST_RANKING")
@Entity
public class JobPostRanking {

    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private JobPostRankingType type;
    private String ranker;
    private long count;
    private LocalDateTime created;
    private LocalDateTime updated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JobPostRankingType getType() {
        return type;
    }

    public void setType(JobPostRankingType type) {
        this.type = type;
    }

    public String getRanker() {
        return ranker;
    }

    public void setRanker(String ranker) {
        this.ranker = ranker;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
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
