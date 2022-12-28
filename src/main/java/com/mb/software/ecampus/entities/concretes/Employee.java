package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Employee represent who is working at university. Each employee belongs to EmployeeDepartment and AcademicUnit.
 * Furthermore, each Employee is a user.
 * @see AcademicDepartment
 * @see AcademicUnit
 * @see User
 * @author Berat Yesbek (Feanor)
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends DbEntity {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_department_id")
    private EmployeeDepartment employeeDepartment;

    @ManyToOne
    @JoinColumn(name = "academic_unit_id")
    private AcademicUnit academicUnit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "salary")
    private float salary;


    /*@OneToMany(mappedBy = "employee")
    private List<AcademicPersonal> academicPersonals;*/

}
