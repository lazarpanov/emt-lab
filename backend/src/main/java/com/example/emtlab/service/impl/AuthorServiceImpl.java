package com.example.emtlab.service.impl;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.Country;
import com.example.emtlab.repository.AuthorRepository;
import com.example.emtlab.repository.CountryRepository;
import com.example.emtlab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long country) {
        Country country1 = countryRepository.findById(country).orElseThrow(RuntimeException::new);
        Author author = new Author(name, surname, country1);
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long country) {
        Country country1 = countryRepository.findById(country).orElseThrow(RuntimeException::new);
        Author author = findById(id).orElseThrow(RuntimeException::new);
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country1);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
