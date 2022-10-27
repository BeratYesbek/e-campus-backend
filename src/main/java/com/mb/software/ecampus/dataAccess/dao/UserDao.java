package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
