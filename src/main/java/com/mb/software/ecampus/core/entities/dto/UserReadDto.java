package com.mb.software.ecampus.core.entities.dto;


import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserReadDto {


    private int id;

    private String username;

    private String email;

    private Date birth_date;

    private Date created_at;
}
