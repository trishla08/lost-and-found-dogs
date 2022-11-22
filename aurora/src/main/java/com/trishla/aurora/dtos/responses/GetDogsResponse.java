package com.trishla.aurora.dtos.responses;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import lombok.Getter;

@Getter
public class GetDogsResponse<T> {
    private final List<T> dogs;
    private final int total;
    
    private GetDogsResponse(List<T> dogs, int total) {
        this.dogs = ImmutableList.copyOf(dogs);
        this.total = total;
    }

    public static class Builder<T> {
        private List<T> dogs = new ArrayList<>();
        private int total;
        
        public Builder<T> dogs(List<T> dogs) {
            this.dogs.addAll(dogs);
            return this;
        }
        
        public Builder<T> total(int total) {
            this.total = total;
            return this;
        }

        public GetDogsResponse<T> build() {
            return new GetDogsResponse<>(dogs, total);
        }
    }
}
