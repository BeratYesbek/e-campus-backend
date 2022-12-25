package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointDao extends JpaRepository<Point,Integer> {
}
