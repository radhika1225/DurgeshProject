package com.CodeWithdurgesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.CodeWithdurgesh.blog.payloads.UserDto;
import com.CodeWithdurgesh.blog.repositories.UserRepo;
import com.CodeWithdurgesh.blog.services.UserService;
import com.CodeWithdurgesh.blog.entities.*;
import com.CodeWithdurgesh.blog.exceptions.*;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
@Autowired
	private ModelMapper modelMapper;
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User saveduser= this.userRepo.save(user);
		return this.userToDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassward(userDto.getPassward());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		return this.userToDto(user);
		 
	}

	@Override
	public List<UserDto> getAllUsers() {
		 List<User> users = this.userRepo.findAll();
		 List<UserDto> userDto = users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		this.userRepo.delete(user);
	}
	
	private User dtoToUser(UserDto userDto) {
		User user= this.modelMapper.map(userDto, User.class);
	//	user.setId(userDto.getId());
	//user.setName(userDto.getName());
	//	user.setEmail(userDto.getEmail());
	//	user.setAbout(userDto.getAbout());
	//	user.setPassward(userDto.getPassward());
		return user;
		
	}
	
		public UserDto userToDto(User user) {
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setEmail(user.getEmail());
			userDto.setPassward(user.getPassward());
			userDto.setAbout(user.getAbout());
			return userDto;
		}
		
}



