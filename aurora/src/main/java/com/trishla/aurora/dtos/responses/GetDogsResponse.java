package com.trishla.aurora.dtos.responses;

import com.google.common.collect.ImmutableList;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetDogsResponse<T> {
    @Singular
    private final ImmutableList<T> dogs;
    private final int total;
}
