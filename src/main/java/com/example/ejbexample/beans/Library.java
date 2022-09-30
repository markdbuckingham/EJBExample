package com.example.ejbexample.beans;

import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface Library {
    void addBook(String bookName);
    List getBooks();
}
