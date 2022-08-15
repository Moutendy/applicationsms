package excel.example.sms.services;

import java.io.IOException;
import java.util.List;

import excel.example.sms.dto.ActualiterDto;

public interface ActualiterService {

	  boolean creationActualiter(ActualiterDto actualiterDto)throws IOException;
	   
	  boolean deleteActualiter(Long id);
	  
	   List<ActualiterDto> listeActualiterDtos();
	  
	   boolean updateActualitere(ActualiterDto actualiterDto);
	  
	  List<ActualiterDto> listeActualiter(long user,long contact);
}
