package com.trishla.aurora.contexts;

public class FilterContext {
    String columnName;
    String value;

    public FilterContext() {
    }

    public FilterContext(String columnName, String value) {
        this.columnName = columnName;
        this.value = value;
    }
}
