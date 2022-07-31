package excel.example.sms.services;

import java.util.List;

import excel.example.sms.dto.MessageDto;

public interface MessageService {

	  boolean creationMessage(MessageDto messageDto);
	   
	  boolean deleteMessage(Long id);
	  
	   List<MessageDto> listeMessageDtos();
	  
	   boolean updateMessage(MessageDto messageDto);
	  
	  List<MessageDto> messageContact(long user,long contact);
}
