package com.CodeWithdurgesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodeWithdurgesh.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
