package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student extends DbEntity {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "academic_department_id")
    public AcademicDepartment academicDepartment;

    @Column(name = "average_success")
    public float averageSuccess;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
