package excel.example.sms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import excel.example.sms.dto.ActualiterDto;
import excel.example.sms.model.ActualiterModel;

@Component
public class ActualiterMapping {
	@Autowired
    DozerBeanMapper mapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	ContactMapper contactMapper;
	
	
	public ActualiterDto actualiterModelToActualiterDto(ActualiterModel actu)
	{
		ActualiterDto actudto=mapper.map(actu, ActualiterDto.class);
		if(actu.getUserid()!=null)
		{
			actudto.setUserid(userMapper.userToUserdto(actu.getUserid()));
		}
		
		if(actu.getContactid()!=null)
		{
			actudto.setContactid(contactMapper.contactModelToContactDto(actu.getContactid()));
		}
		
		return actudto;
	}
	
	public ActualiterModel actualDtoToActuModel(ActualiterDto actudto)
	{
		ActualiterModel actu=mapper.map(actudto, ActualiterModel.class);
		
		if(actudto.getUserid()!=null)
		{
			actu.setUserid(userMapper.userDtoToUser(actudto.getUserid()));
		}
		
		if(actudto.getContactid()!=null)
		{
			actu.setContactid(contactMapper.contactDtoTocontactModel(actudto.getContactid()));
		}
		return actu;
	}
	
	public List<ActualiterModel> listactuDtoToActuModel(List<ActualiterDto> actudto)
	{
		List<ActualiterModel> actuist=new ArrayList<ActualiterModel>();
		
		actudto.forEach(m-> actuist.add(actualDtoToActuModel(m)));
		return actuist;
	}
	
	
	public List<ActualiterDto> listactuModelToActuDto(List<ActualiterModel> actu)
	{
		List<ActualiterDto> actulist=new ArrayList<ActualiterDto>();
		
		actu.forEach(m->actulist.add(actualiterModelToActualiterDto(m)) );
		
		return actulist;
	}

}
