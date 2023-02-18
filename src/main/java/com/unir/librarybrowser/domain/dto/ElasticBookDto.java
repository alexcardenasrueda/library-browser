package com.unir.librarybrowser.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

@Document(indexName = "books", createIndex = true)
@Data
@NoArgsConstructor
public class ElasticBookDto {

    @Id
    private long bookId;

    @Field(type = FieldType.Integer, name = "ISBN")
    private long isbn;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name="name"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
    private String name;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name="author"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
    private String author;

    @Field(type = FieldType.Integer, name = "publicationYear")
    private int publicationYear;

    @Field(type = FieldType.Text, name = "synopsis")
    private String synopsis;

    @Field(type = FieldType.Text, name = "image")
    private String image;
}

