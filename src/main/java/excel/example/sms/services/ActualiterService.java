package excel.example.sms.services;

import java.util.List;

import excel.example.sms.dto.ActualiterDto;

public interface ActualiterService {

	  boolean creationActualiter(ActualiterDto actualiterDto);
	   
	  boolean deleteActualiter(Long id);
	  
	   List<ActualiterDto> listeActualiterDtos();
	  
	   boolean updateActualitere(ActualiterDto actualiterDto);
	  
	  List<ActualiterDto> listeActualiter(long user,long contact);
}
