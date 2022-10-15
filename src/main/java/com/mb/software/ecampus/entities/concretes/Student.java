package com.mb.software.ecampus.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name="academic_department_id")
    private AcademicDepartment academicDepartment;

    @Column(name = "average_success")
    private float averageSuccess;

}
