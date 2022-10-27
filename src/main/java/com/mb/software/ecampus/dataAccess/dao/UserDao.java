package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
