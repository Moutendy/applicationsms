package excel.example.sms.services;

import java.util.List;

import excel.example.sms.dto.ContactDto;
import excel.example.sms.dto.UserDto;

public interface ContactService {

	   boolean creationContact(ContactDto contact);
	   
	   boolean deleteContact(Long id);
	  
	   List<ContactDto> listeContactDtos();
	  
	   boolean updateContact(ContactDto contact);
	  
	  List<ContactDto> listeContactofUserDtos(UserDto user);
}
