package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_departments")
public class EmployeeDepartment extends DbEntity {

    @Id
    @Column(name = "employee_department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

    @Column(name = "name")
    private String name;

  /*  @OneToMany(mappedBy = "employeeDepartment")
    private List<Employee> employee;*/
}
