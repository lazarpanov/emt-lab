package com.example.emtlab.model.dto;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.enumerations.BookCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private BookCategory category;
    private Long author;
    private int availableCopies;
}
