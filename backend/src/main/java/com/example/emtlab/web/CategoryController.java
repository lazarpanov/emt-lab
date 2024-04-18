package com.example.emtlab.web;

import com.example.emtlab.model.enumerations.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping
    public List<BookCategory> getAllCategories() {
        return Arrays.stream(BookCategory.values()).collect(Collectors.toList());
    }
}
