package excel.example.sms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excel.example.sms.dto.ContactDto;
import excel.example.sms.dto.UserDto;
import excel.example.sms.mapper.ContactMapper;
import excel.example.sms.repositories.ContactRepository;
import excel.example.sms.services.ContactService;
@Service
public class ContactServiceImpl implements ContactService{

	
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	ContactMapper contactMapper;
	
	@Override
	public boolean creationContact(ContactDto contact) {
		// TODO Auto-generated method stub
		contactRepository.save(contactMapper.contactDtoTocontactModel(contact));
		return true;
	}

	@Override
	public boolean deleteContact(Long id) {
		// TODO Auto-generated method stub
		if(contactRepository.findById(id).isPresent())
		{
			contactRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<ContactDto> listeContactDtos() {
		// TODO Auto-generated method stub
		return contactMapper.ListContactModelTolistContactDto(contactRepository.findAll());
	}

	@Override
	public boolean updateContact(ContactDto contact) {
		// TODO Auto-generated method stub
		
		if(contactRepository.findById(contact.getId()).isPresent())
		{
			contactRepository.save(contactMapper.contactDtoTocontactModel(contact));
			return true;
		}
		return false;
	}

	@Override
	public List<ContactDto> listeContactofUserDtos(UserDto user) {
		// TODO Auto-generated method stub
		return contactMapper.ListContactModelTolistContactDto(contactRepository.findAllUsers(user.getId()));
	}

}
