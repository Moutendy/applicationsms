package excel.example.sms.services;

import java.util.List;

import excel.example.sms.dto.UserDto;

public interface UserService {

   boolean creationUser(UserDto user);
  
   boolean deleteUser(Long id);
  
   List<UserDto> listeUserDtos();
  
   boolean updateUser(UserDto user);
  
}
