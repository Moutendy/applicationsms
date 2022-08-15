package excel.example.sms.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excel.example.sms.dto.UserDto;
import excel.example.sms.mapper.UserMapper;
import excel.example.sms.model.UsersModel;
import excel.example.sms.repositories.UserReposytory;
import excel.example.sms.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserReposytory userReposytory;
	
	@Autowired
	UserMapper userMapper;
	

	@Override
	public boolean creationUser(UserDto user) {
		// TODO Auto-generated method stub
		
		userReposytory.save(userMapper.userDtoToUser(user));
		return true;
		
	}

	@Override
	public boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		
		if(userReposytory.findById(id).isPresent())
		{
			userReposytory.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<UserDto> listeUserDtos() {
		// TODO Auto-generated method stub
		
		
		return userMapper.userListToUser(userReposytory.findAll());
	}

	@Override
	public boolean updateUser(UserDto user) {
		// TODO Auto-generated method stub
		
		if(userReposytory.findById(user.getId()).isPresent())
		{
			userReposytory.save(userMapper.userDtoToUser(user));
			return true;
		}
		return false;
	}

	@Override
	public Optional<UsersModel> profile(Long id) {
		
		return userReposytory.findById(id);
	}

}
