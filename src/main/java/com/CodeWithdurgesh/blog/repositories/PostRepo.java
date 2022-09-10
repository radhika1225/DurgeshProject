package com.CodeWithdurgesh.blog.repositories;

import java.awt.print.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CodeWithdurgesh.blog.entities.Category;
import com.CodeWithdurgesh.blog.entities.Post;
import com.CodeWithdurgesh.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> getAllByUser(User user);
	List<Post> getAllByCategory(Category category);
	List<Post> findByTitleContaining(String title);
	//Page<Post> findAll(Pageable p);
	//Page<Post> findAll(Pageable p);
}

