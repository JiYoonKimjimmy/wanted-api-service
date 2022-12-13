package me.jimmyberg.wanted.entity;

import me.jimmyberg.wanted.common.entity.BaseEntity;
import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;

import javax.persistence.*;

@Table(name = "JOB_POST_RANKING")
@Entity
public class JobPostRanking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private JobPostRankingType type;
    private String ranker;
    private long count;

    public JobPostRanking count() {
        this.count++;
        return this;
    }

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

}
