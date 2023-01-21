package com.unir.librarybrowser.domain.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
public class BookDto {

    private long bookId;
    private String isbn;
    private String name;
    private String author;
    private LocalDate publicationYear;
    private String synopsis;
    private String image;
}
