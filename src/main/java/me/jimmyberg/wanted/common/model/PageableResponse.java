package me.jimmyberg.wanted.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;

import java.util.List;

public abstract class PageableResponse<T> {

    @Schema(description = "Page 번호")
    private int number;
    @Schema(description = "Page 크기")
    private int size;
    @Schema(description = "전체 Page 수")
    private int totalPages;
    @Schema(description = "전체 항목 수")
    private long totalElements;
    @Schema(description = "Page 당 항목 수")
    private int numberOfElements;
    @Schema(description = "첫 Page 여부")
    private boolean first;
    @Schema(description = "마지막 Page 여부")
    private boolean last;
    @Schema(description = "Content 정보")
    private List<T> content;

    public PageableResponse(Page<T> pageable) {
        this.number = pageable.getNumber();
        this.size = pageable.getSize();
        this.totalPages = pageable.getTotalPages();
        this.totalElements = pageable.getTotalElements();
        this.numberOfElements = pageable.getNumberOfElements();
        this.first = pageable.isFirst();
        this.last = pageable.isLast();
        this.content = pageable.getContent();
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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

}
