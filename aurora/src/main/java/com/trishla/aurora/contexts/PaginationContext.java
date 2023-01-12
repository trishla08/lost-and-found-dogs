package com.trishla.aurora.contexts;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaginationContext {
    private final int numberOfRecords;
    private final int numberOfPages;
}
