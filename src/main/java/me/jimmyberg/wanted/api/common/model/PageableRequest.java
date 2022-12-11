package me.jimmyberg.wanted.api.common.model;

import org.springframework.data.domain.PageRequest;

public class PageableRequest {

    private int number;
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
