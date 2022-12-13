package me.jimmyberg.wanted.common.model;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import io.swagger.v3.oas.annotations.media.Schema;
import me.jimmyberg.wanted.common.Constant;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

import static me.jimmyberg.wanted.entity.QJobPost.jobPost;

public class PageableRequest {

    @Schema(description = "Page 번호", defaultValue = "0")
    private int number = 0;
    @Schema(description = "Page 크기", defaultValue = "10")
    private int size = 10;
    @Schema(description = "조회 시작 일자")
    private String fromDate = "19000101";
    @Schema(description = "조회 종료 일자")
    private String toDate = "99991231";
    @Schema(description = "정렬 기준", defaultValue = "id")
    private String sortBy = "id";
    @Schema(description = "정렬 방향", defaultValue = "DESC")
    private Order order = Order.DESC;

    /**
     * Page Request 생성
     */
    public PageRequest pageRequest() {
        return PageRequest.of(number, size);
    }

    /**
     * where query 생성
     */
    public BooleanExpression generateWhere() {
        LocalDateTime fromDate = LocalDateTime.parse(this.fromDate + "000000", Constant.DATE_TIME_FORMAT_yyyyMMddHHmmss);
        LocalDateTime toDate = LocalDateTime.parse(this.toDate + "235959", Constant.DATE_TIME_FORMAT_yyyyMMddHHmmss);
        return jobPost.posted.between(fromDate, toDate);
    }

    public OrderSpecifier<String> orderBy(Path<?> entity) {
        Path<String> fieldPath = Expressions.path(String.class, entity, this.sortBy);
        return new OrderSpecifier<>(this.order, fieldPath);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
