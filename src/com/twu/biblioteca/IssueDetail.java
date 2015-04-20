package com.twu.biblioteca;

/**
 * Created by dabluk on 17/04/15.
 */
public class IssueDetail {
    private Book book;
    private String customerName;

    public IssueDetail(String name, Book book) {
        this.book = book;
        this.customerName = name;

    }

    public Book getBook() {
        return book;
    }

    public String getCustomerName() {
        return customerName;
    }
}
