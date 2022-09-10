package com.CodeWithdurgesh.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
//@NonNull
//@Notempty
public class UserDto {

	
	private int id;
	@NotEmpty
	@Size(min=4,message="username must be min of 4 characters")
	private String name;
	@Email(message="your email address is not valid!")
	private String email;
	@NotNull
	@Size(min=3,max=10,message="passward must be min 3 chars and max of 10 chars!!")
	private String passward;
	@NotNull
	private String about;
}