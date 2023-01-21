package com.unir.librarybrowser.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {

    private long personId;
    private String uid;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
}
