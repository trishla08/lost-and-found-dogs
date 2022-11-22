package com.trishla.aurora.contexts;

public class PaginationContext {
    int numberOfRecords;
    int numberOfPages;
    
    public PaginationContext() {
    }
    
    public PaginationContext(int numberOfRecords, int numberOfPages) {
        this.numberOfRecords = numberOfRecords;
        this.numberOfPages = numberOfPages;
    }
}
