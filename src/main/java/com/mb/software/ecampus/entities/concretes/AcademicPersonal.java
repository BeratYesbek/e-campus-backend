package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import com.mb.software.ecampus.entities.concretes.enums.AcademicRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * AcademicPersonal represent who is working as an academician. AcademicPersonal is an Employee
 * @see Employee
 * @author Melih Dede (MDD)
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "academic_personals")
public class AcademicPersonal extends DbEntity {

    @Id
    @Column(name = "academic_personal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "academic_rate")
    private AcademicRate academicRate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "nnumber_of_theses")
    private int numberOfTheses;

    @Column(name = "bachooler_degree")
    private String bachoolerDegree;

    @Column(name = "master_degree")
    private String masterDegree;

    @Column(name = "doctorate_degree")
    private String doctorateDegree;

    @Column(name = "institutional_phone_number")
    private String institutionalPhoneNumber;
}
