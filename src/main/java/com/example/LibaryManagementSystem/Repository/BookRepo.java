package com.example.LibaryManagementSystem.Repository;

import com.example.LibaryManagementSystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {

}
