package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.ChoosedLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoosedLessonDao extends JpaRepository<ChoosedLesson,Integer> {
}
