package excel.example.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.sms.dto.ContactDto;
import excel.example.sms.dto.UserDto;
import excel.example.sms.services.ContactService;

@RestController
public class ContactContraller {

	@Autowired
	ContactService contactService;

	
	@GetMapping(value="/listeContactofUser")
	public 	ResponseEntity<List<ContactDto>> listeContactofUser(@RequestBody UserDto user)
	{
		 return ResponseEntity.status(HttpStatus.OK).body(contactService.listeContactofUserDtos(user));
	}
	
	
	@GetMapping(value="/listeContact")
	public 	ResponseEntity<List<ContactDto>> listeContact()
	{
		 return ResponseEntity.status(HttpStatus.OK).body(contactService.listeContactDtos());
	}
	
	@PostMapping(value="/ajoutercontact")
	public ResponseEntity<String>ajouterContact(@RequestBody ContactDto contactDto)
	{
	if(contactService.creationContact(contactDto))
	{
	
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	
	@PutMapping(value="/updatecontact")
	public ResponseEntity<String>updateContact(@RequestBody ContactDto contactDto)
	{
	if(contactService.updateContact(contactDto))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}
	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	
	@DeleteMapping(value="/deleteContact/{id}")
	public ResponseEntity<String>deleteContact(@PathVariable Long id)
	{
	if(contactService.deleteContact(id))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}

}
