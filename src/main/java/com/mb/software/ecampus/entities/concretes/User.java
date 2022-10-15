package com.mb.software.ecampus.entities.concretes;


import com.mb.software.ecampus.entities.abstracts.DbEntity;
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
    public String username;

    @Column(name = "email")
    @NotNull
    public String email;

    @Column(name = "birth_date")
    @NotNull
    public Date birth_date;

    @Column(name = "created_at")
    public Date created_at;
}
