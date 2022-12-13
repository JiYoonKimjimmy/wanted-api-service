package me.jimmyberg.wanted.api.v1.jobpost.model;

import com.querydsl.core.BooleanBuilder;
import me.jimmyberg.wanted.common.model.PageableRequest;

import java.util.Arrays;

import static me.jimmyberg.wanted.entity.QJobPost.jobPost;

public class FindJobPostsRequest {

    private String text;

    private PageableRequest pageable;

    /**
     * where query 생성
     * @return
     */
    public BooleanBuilder generateWhere() {
        BooleanBuilder where = new BooleanBuilder();
        if (text != null) {
            text = "%" + text + "%";
            Arrays
                .asList(jobPost.company.name.like(text), jobPost.jobType.like(text), jobPost.country.like(text))
                .forEach(where::or);
        }
        where.and(pageable.generateWhere());
        return where;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }

}
