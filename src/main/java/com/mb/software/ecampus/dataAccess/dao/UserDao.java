package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
     User findByEmail(String email);
}
