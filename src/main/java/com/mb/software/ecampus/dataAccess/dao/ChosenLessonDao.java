package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.ChosenLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChosenLessonDao extends JpaRepository<ChosenLesson,Integer> {
}
