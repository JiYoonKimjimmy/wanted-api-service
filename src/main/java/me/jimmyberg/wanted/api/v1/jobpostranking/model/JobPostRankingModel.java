package me.jimmyberg.wanted.api.v1.jobpostranking.model;

import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;
import me.jimmyberg.wanted.entity.JobPostRanking;

import java.util.ArrayList;
import java.util.List;

public class JobPostRankingModel {

    private int rank;
    private JobPostRankingType type;
    private String ranker;
    private long count;

    public JobPostRankingModel(JobPostRanking entity, int rank) {
        this.type = entity.getType();
        this.rank = rank;
        this.ranker = entity.getRanker();
        this.count = entity.getCount();
    }

    public static List<JobPostRankingModel> of(List<JobPostRanking> entities) {
        List<JobPostRankingModel> result = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            JobPostRankingModel model = new JobPostRankingModel(entities.get(i), (i + 1));
            result.add(model);
        }
        return result;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
