package com.unir.librarybrowser.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.*;
import java.util.List;

@Document(indexName = "books", createIndex = true)
@Data
@NoArgsConstructor
public class ElasticBook {

    @Id
    private String bookId;

    @Column(name = "ISBN")
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
