package com.mb.software.ecampus.core.entities;


import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import com.mb.software.ecampus.core.entities.enums.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends DbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "address")
    private String address;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

 /*   @OneToMany(mappedBy = "user")
    private List<Student> students;

    @OneToMany(mappedBy = "user")
    private List<Employee> employees;

    @OneToMany(mappedBy = "user")
    private List<SystemAdministrator> systemAdministrators;*/
}
