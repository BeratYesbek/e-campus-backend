package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonDao extends JpaRepository<Lesson,Integer> {
}
