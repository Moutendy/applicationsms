package excel.example.sms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excel.example.sms.dto.ActualiterDto;
import excel.example.sms.mapper.ActualiterMapping;
import excel.example.sms.repositories.ActualiterRepository;
import excel.example.sms.services.ActualiterService;

@Service
public class ActualiterServiceImpl implements ActualiterService{

	@Autowired
	ActualiterRepository actualiterRepository;
	
	@Autowired
	ActualiterMapping actualiterMapping;
	
	
	@Override
	public boolean creationActualiter(ActualiterDto actualiterDto) {
		// TODO Auto-generated method stub
		
		actualiterRepository.save(actualiterMapping.actualDtoToActuModel(actualiterDto));
		return true;
		
	}

	@Override
	public boolean deleteActualiter(Long id) {
		// TODO Auto-generated method stub
		if(actualiterRepository.findById(id).isPresent())
		{
			actualiterRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<ActualiterDto> listeActualiterDtos() {
		// TODO Auto-generated method stub
		return actualiterMapping.listactuModelToActuDto(actualiterRepository.findAll());
	}

	@Override
	public boolean updateActualitere(ActualiterDto actualiterDto) {
		// TODO Auto-generated method stub
		
		if(actualiterRepository.findById(actualiterDto.getId()).isPresent())
		{
			actualiterRepository.save(actualiterMapping.actualDtoToActuModel(actualiterDto));	
			return true;
		}
		return false;
	}

	@Override
	public List<ActualiterDto> listeActualiter(long user, long contact) {
		// TODO Auto-generated method stub
		return actualiterMapping.listactuModelToActuDto(actualiterRepository.listeActualiterModel(contact, user));
	}

}
