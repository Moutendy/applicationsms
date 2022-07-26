package excel.example.sms.mapper;


import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import excel.example.sms.dto.UserDto;
import excel.example.sms.model.UsersModel;

@Component
public class UserMapper {

	@Autowired
    DozerBeanMapper mapper;
	
	public UserDto userToUserdto(UsersModel user)
	{
		return mapper.map(user, UserDto.class);
	}
	
	
	public UsersModel userDtoToUser(UserDto userdto)
	{
		return mapper.map(userdto, UsersModel.class);
	}
	
	
	public List<UserDto> userListToUser(List<UsersModel> users)
	{
		List<UserDto> user=new ArrayList<UserDto>();
		
		for(UsersModel usermodel:users)
		{
			user.add(userToUserdto(usermodel));
		}
		return user;
	}
	
	public List<UsersModel> userDtoToListUser(List<UserDto> usersdto)
	{
		List<UsersModel> user=new ArrayList<UsersModel>();
		
		for(UserDto userdto:usersdto)
		{
			user.add(userDtoToUser(userdto));
		}
		return user;
	}
}
