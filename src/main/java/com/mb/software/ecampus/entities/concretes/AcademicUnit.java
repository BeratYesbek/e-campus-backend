package com.mb.software.ecampus.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
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
public class AcademicUnit extends DbEntity {
    @Id
    @Column(name = "academic_unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    private String name;

    @Column(name = "academicType")
    private AcademicType academicType;

  /*  @OneToMany(mappedBy = "academicUnit")
    @JsonManagedReference
    private List<AcademicDepartment> academicDepartments;

    @OneToMany(mappedBy = "academicUnit")
    @JsonManagedReference
    private List<Employee> employees;*/
}
