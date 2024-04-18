package com.example.emtlab.service;

import com.example.emtlab.model.Book;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.enumerations.BookCategory;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(String name, String continent);
    Optional<Country> edit(Long id, String name, String continent);
    void deleteById(Long id);
}
