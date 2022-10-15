package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_administrators")
public class SystemAdministrator  extends User {

    @Id
    @JoinColumn(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
