package com.CodeWithdurgesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodeWithdurgesh.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
