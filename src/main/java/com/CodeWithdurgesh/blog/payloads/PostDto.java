package com.CodeWithdurgesh.blog.payloads;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.CodeWithdurgesh.blog.entities.Category;
import com.CodeWithdurgesh.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	
	  private String title;
	  private String content;
	  //private CategoryDto categoryDto;
	  private String imageName;
	  
	  private Date addedDate;
	  
	  
	 
		private CategoryDto category;
		
		private UserDto user;

	  
}
