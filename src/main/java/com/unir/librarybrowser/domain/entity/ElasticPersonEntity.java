package com.unir.librarybrowser.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

@Document(indexName = "people", createIndex = true)
@Data
@NoArgsConstructor
public class ElasticPersonEntity {

    @Id
    private long id;

    @Field(type = FieldType.Keyword, name = "uid")
    private String uid;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name="name"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
    private String name;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name="last_name"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
    private String lastName;

    @Field(type = FieldType.Text, name = "address")
    private String address;

    @Field(type = FieldType.Text, name = "phone")
    private String phone;

    @Field(type = FieldType.Text, name = "email")
    private String email;
}