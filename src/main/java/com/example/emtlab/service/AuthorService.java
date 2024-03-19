package com.example.emtlab.service;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.Book;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.enumerations.BookCategory;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(String name, String surname, Long country);
    Optional<Author> edit(Long id, String name, String surname, Long country);
    void deleteById(Long id);
}
