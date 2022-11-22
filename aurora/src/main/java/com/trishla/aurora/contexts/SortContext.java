package com.trishla.aurora.contexts;

public class SortContext {
    String columnName;
    SortingOrder order;

    public SortContext() {
    }

    public SortContext(String columnName, SortingOrder order) {
        this.columnName = columnName;
        this.order = order;
    }

    enum SortingOrder {
        ASCENDING,
        DESCENDING
    }
}
