package com.trishla.aurora.dtos.requests;

import com.trishla.aurora.contexts.PaginationContext;
import com.trishla.aurora.contexts.SortContext;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetDogsRequest {
    private String correlationId;
    private SortContext sort;
    private PaginationContext page;
}
