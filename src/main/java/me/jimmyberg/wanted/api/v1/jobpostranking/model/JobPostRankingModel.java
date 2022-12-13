package me.jimmyberg.wanted.api.v1.jobpostranking.model;

import io.swagger.v3.oas.annotations.media.Schema;
import me.jimmyberg.wanted.common.enumerate.JobPostRankingType;
import me.jimmyberg.wanted.entity.JobPostRanking;

import java.util.ArrayList;
import java.util.List;

public class JobPostRankingModel {

    @Schema(description = "랭킹 순위")
    private int rank;
    @Schema(description = "랭킹 조회 구분")
    private JobPostRankingType type;
    @Schema(description = "랭킹 정보")
    private String ranker;
    @Schema(description = "공고 등록 건수")
    private long count;

    public static JobPostRankingModel of(JobPostRanking entity, int rank) {
        JobPostRankingModel model = new JobPostRankingModel();
        model.setType(entity.getType());
        model.setRank(rank);
        model.setRanker(entity.getRanker());
        model.setCount(entity.getCount());
        return model;
    }

    public static List<JobPostRankingModel> of(List<JobPostRanking> entities) {
        List<JobPostRankingModel> result = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            JobPostRankingModel model = JobPostRankingModel.of(entities.get(i), (i + 1));
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
