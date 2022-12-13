package me.jimmyberg.wanted.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.PageRequest;

public class PageableRequest {

    @Schema(description = "Page Number", defaultValue = "0")
    private int number;
    @Schema(description = "Page Size", defaultValue = "10")
    private int size;

    public PageRequest toPageRequest() {
        return PageRequest.of(number, size);
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

}
