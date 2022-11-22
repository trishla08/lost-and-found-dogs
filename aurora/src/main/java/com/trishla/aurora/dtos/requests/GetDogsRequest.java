package com.trishla.aurora.dtos.requests;

import com.trishla.aurora.contexts.PaginationContext;
import com.trishla.aurora.contexts.SortContext;

import lombok.Getter;

@Getter
public class GetDogsRequest {
    String correlationId;
    SortContext sort;
    PaginationContext page;
}
