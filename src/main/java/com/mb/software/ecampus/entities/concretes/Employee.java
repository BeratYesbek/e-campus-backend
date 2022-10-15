package com.mb.software.ecampus.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "employee_department_id")
    public EmployeeDepartment employeeDepartment;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "academic_unit_id")
    public AcademicUnit academicUnit;

}
