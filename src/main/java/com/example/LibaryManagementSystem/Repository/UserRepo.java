package com.example.LibaryManagementSystem.Repository;

import com.example.LibaryManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
