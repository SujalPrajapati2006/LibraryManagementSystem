package com.example.LibaryManagementSystem.Service;


import com.example.LibaryManagementSystem.Entity.User;
import com.example.LibaryManagementSystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User>  findAll(){
         return userRepo.findAll();
    }

    public User save(User user){
         return userRepo.save(user);
    }
}
