package com.unir.librarybrowser.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticBookDto {

    private long id;
    private long isbn;
    private String name;
    private String author;
    private int publicationYear;
    private String synopsis; // To full text
    private String image;
}

