package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.LessonContent;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LessonContentDao extends JpaRepository<LessonContent, Integer> {
}
