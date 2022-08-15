package excel.example.sms.services;

import java.util.List;
import java.util.Optional;

import excel.example.sms.dto.UserDto;
import excel.example.sms.model.UsersModel;

public interface UserService {

   boolean creationUser(UserDto user);
  
   boolean deleteUser(Long id);
  
   List<UserDto> listeUserDtos();
  
   boolean updateUser(UserDto user);
   
   Optional<UsersModel> profile(Long id);
  
}
