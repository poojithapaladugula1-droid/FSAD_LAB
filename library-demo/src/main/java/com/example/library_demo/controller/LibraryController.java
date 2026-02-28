package com.example.library_demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.example.library_demo.model.Book;

@RestController
@RequestMapping("/library")
public class LibraryController {

    // In-memory list to store books
    List<Book> bookList = new ArrayList<>();


    // 1. Welcome API
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Library Management System";
    }


    // 2. Count API
    @GetMapping("/count")
    public int getCount() {
        return bookList.size();
    }


    // 3. Price API
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }


    // 4. Get list of books
    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Spring Boot Basics");
        books.add("Data Structures");

        return books;
    }


    // 5. Get book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }


    // 6. Search book by title
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }


    // 7. Get books by author
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }


    // 8. Add book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }


    // 9. View books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }

}