package excel.example.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.sms.dto.ContactDto;
import excel.example.sms.mapper.ContactMapper;
import excel.example.sms.model.ContactModel;
import excel.example.sms.repositories.ContactRepository;

@RestController
public class ContactContraller {

	@Autowired
	ContactRepository contactRepository;
	@Autowired
	ContactMapper contactMapper;
	
	@PostMapping(value="/ajoutercontact")
	public void ajouter(@RequestBody ContactDto contact)
	{
		contactRepository.save(contactMapper.contactDtoTocontactModel(contact));
	}
	
	@GetMapping(value="/getcontact")
	public List<ContactModel> getcontact()
	{
		return contactRepository.findAllUsers();
	}
}
