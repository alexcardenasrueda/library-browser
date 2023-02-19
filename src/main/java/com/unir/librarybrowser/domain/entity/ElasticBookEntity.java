package com.unir.librarybrowser.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.annotation.Id;

@Document(indexName = "books", createIndex = true)
@Data
@NoArgsConstructor
public class ElasticBookEntity {

    @Id
    private long id;

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

