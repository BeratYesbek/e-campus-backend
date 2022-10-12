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
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name = "birth_date")
    @NotNull
    private Date birth_date;

    @Column(name = "created_at")
    private Date created_at;
}
