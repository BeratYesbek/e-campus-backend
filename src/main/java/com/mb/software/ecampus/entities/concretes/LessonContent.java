package com.mb.software.ecampus.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson_contents")
public class LessonContent {

    @Id
    @Column(name = "lesson_content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title,")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "week")
    private int week;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

}
