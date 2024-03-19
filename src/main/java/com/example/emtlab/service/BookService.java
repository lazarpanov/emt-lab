package com.example.emtlab.service;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.Book;
import com.example.emtlab.model.dto.BookDto;
import com.example.emtlab.model.enumerations.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, BookCategory category, Long author, int availableCopies);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, String name, BookCategory category, Long author, int availableCopies);
    Optional<Book> edit(Long id, BookDto bookDto);
    void deleteById(Long id);
    boolean rentById(Long id);
}
