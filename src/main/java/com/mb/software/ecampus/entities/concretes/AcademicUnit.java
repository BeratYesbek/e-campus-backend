package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "academic_units")
public class AcademicUnit {
    @Id
    @Column(name = "academic_unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "academicType")
    private AcademicType academicType;

    @OneToMany(mappedBy = "academicUnit")
    private List<AcademicDepartment> academicDepartments;

    @OneToMany(mappedBy = "academicUnit")
    private List<Employee> employees;
}
