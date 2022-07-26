package excel.example.sms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import excel.example.sms.dto.ContactDto;
import excel.example.sms.model.ContactModel;

@Component
public class ContactMapper {

	@Autowired
    DozerBeanMapper mapper;
	
	@Autowired
	UserMapper userMapper;
	
	public ContactModel contactDtoTocontactModel(ContactDto contactdto)
	{
		ContactModel contact= mapper.map(contactdto, ContactModel.class);
	
		if(contactdto.getUserdestinataire()!=null)
		{
			contact.setUserdestinataire(userMapper.userDtoToUser(contactdto.getUserdestinataire()));
		}
		
		return contact;
	}
	
	public ContactDto contactModelToContactDto(ContactModel contactModel)
	{
		ContactDto contact =mapper.map(contactModel, ContactDto.class);
		
		if(contactModel.getUserdestinataire()!=null)
		{
			contact.setUserdestinataire(userMapper.userToUserdto(contactModel.getUserdestinataire()));
		}
		return contact;
	}
	
	public List<ContactModel> listContactDtoToListContactModel(List<ContactDto> contactdto)
	{
		
		List<ContactModel> contactList= new ArrayList<ContactModel>();
		
		contactdto.forEach(c-> contactList.add(contactDtoTocontactModel(c)) );
		
		return contactList;
	
	}
	
	public List<ContactDto> ListContactModelTolistContactDto(List<ContactModel> contact)
	{
		
		List<ContactDto> contactDtoList= new ArrayList<ContactDto>();
		
		contact.forEach(c-> contactDtoList.add(contactModelToContactDto(c)));
		
		return contactDtoList;
	
	}
	
	
} 
