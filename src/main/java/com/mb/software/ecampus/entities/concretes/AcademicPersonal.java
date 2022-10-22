package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.entities.concretes.enums.AcademicRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "academic_personals")
public class AcademicPersonal {

    @Id
    @Column(name = "academic_personal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "academic_rate")
    private AcademicRate academicRate;


}
