package excel.example.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.sms.dto.UserDto;
import excel.example.sms.mapper.UserMapper;
import excel.example.sms.repositories.UserReposytory;

@RestController
public class UserControllers {

	@Autowired
	UserReposytory userReposytory;
	
	@Autowired
	UserMapper userMapper;
	
	@PostMapping(value="/userajouter")
	public void ajouterUser(@RequestBody UserDto user)
	{
		userReposytory.save(userMapper.userDtoToUser(user));
	}
}
