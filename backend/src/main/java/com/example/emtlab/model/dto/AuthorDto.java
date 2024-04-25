package com.example.emtlab.model.dto;

import com.example.emtlab.model.Country;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Long country;
}
