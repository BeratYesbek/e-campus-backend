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
public class AcademicUnit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "academicType")
    private AcademicType academicType;

    @OneToMany(mappedBy = "academicUnit")
    private List<AcademicDepartment> academicDepartments;

    @OneToMany(mappedBy = "academicUnit")
    private List<Employee> employees;
}
