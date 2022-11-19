package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * AcademicDepartment represent department in Academic Unit
 * @example AcademicDepartment => Computer Engineering, AcademicUnit => Engineering Faculty
 * @see AcademicUnit
 * @author Berat Yesbek (Feanor)
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "academic_departments")
public class AcademicDepartment extends DbEntity {

    @Id
    @Column(name = "academic_department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "academic_unit_id")
    private AcademicUnit academicUnit;

 /*   @OneToMany(mappedBy = "academicDepartment")
    private List<Student> students;*/
}
