package com.learnleadgrow.taskapp.repository;

import com.learnleadgrow.taskapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
