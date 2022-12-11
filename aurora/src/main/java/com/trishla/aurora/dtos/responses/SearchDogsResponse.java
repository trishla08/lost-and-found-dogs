package com.trishla.aurora.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class SearchDogsResponse<T> {
    private final List<T> list;
    private final int total;

    private SearchDogsResponse(List<T> list, int total) {
        this.list = list;
        this.total = total;
    }

    public static class Builder<T> {
        private List<T> list = new ArrayList<>();
        private int total;
        
        public Builder<T> dogs(List<T> list) {
            this.list.addAll(list);
            return this;
        }
        
        public Builder<T> total(int total) {
            this.total = total;
            return this;
        }

        public SearchDogsResponse<T> build() {
            return new SearchDogsResponse<>(list, total);
        }
    }

}
