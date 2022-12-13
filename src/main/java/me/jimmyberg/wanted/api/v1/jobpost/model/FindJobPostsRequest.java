package me.jimmyberg.wanted.api.v1.jobpost.model;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import me.jimmyberg.wanted.common.enumerate.JobPostSortBy;
import me.jimmyberg.wanted.common.model.PageableRequest;

import java.util.Arrays;

import static me.jimmyberg.wanted.entity.QJobPost.jobPost;

public class FindJobPostsRequest extends PageableRequest {

    private String text;

    /**
     * where query 생성
     */
    public BooleanBuilder generateWhere() {
        BooleanBuilder where = new BooleanBuilder();
        if (text != null) {
            text = "%" + text + "%";
            Arrays
                .asList(jobPost.company.name.like(text), jobPost.jobType.like(text), jobPost.locale.country.like(text))
                .forEach(where::or);
        }
        where.and(super.periodWhere());
        return where;
    }

    @Override
    public OrderSpecifier<String> orderBy(Path<?> entity) {
        // super class 의 sortBy 를 JobPostSortBy 변환
        String sortBy = JobPostSortBy.valueOf(super.getSortBy()).getProperty();
        super.setSortBy(sortBy == null ? "id" : sortBy);
        return super.orderBy(entity);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
