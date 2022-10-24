package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson extends DbEntity {

    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "academic_personal_id")
    private AcademicPersonal academicPersonal;

    @ManyToOne
    @JoinColumn(name = "academic_department_id")
    private AcademicDepartment academicDepartment;

    @Column(name = "name")
    private String name;

}
