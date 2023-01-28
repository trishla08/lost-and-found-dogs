package com.trishla.aurora.contexts;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SortContext {
    private final String columnName;
    private final SortingOrder order;

    enum SortingOrder {
        ASCENDING,
        DESCENDING
    }
}
