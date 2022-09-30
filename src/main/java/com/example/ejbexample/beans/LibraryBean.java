package com.example.ejbexample.beans;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
@SessionScoped
public class LibraryBean implements Library, Serializable {

    List<String> bookShelf;

    public LibraryBean() {
        bookShelf = new ArrayList<>();
    }

    public void addBook(String bookName) {
        System.err.println("addBook() " + bookShelf.size());
        bookShelf.add(bookName);
    }

    public List<String> getBooks() {
        System.err.println("getBooks()");
        return bookShelf;
    }
}
