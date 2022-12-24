package com.mb.software.ecampus.entities.concretes;

import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "points")
public class Point extends DbEntity {

    @Id
    @Column(name = "point_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "year")
    private int year;

    @Column(name = "period")
    private int period;

    @Column(name = "midterm_point")
    private int midtermPoint;

    @Column(name = "final_point")
    private int finalPoint;

    @Column(name = "grade")
    private String grade;
}
