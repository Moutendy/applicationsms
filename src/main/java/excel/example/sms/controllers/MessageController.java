package excel.example.sms.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import excel.example.sms.dto.MessageDto;
import excel.example.sms.services.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@PostMapping(value="/sendMessage")
	public ResponseEntity<String>sendMessage(@ModelAttribute MessageDto messageDto)
	{
	if(messageService.creationMessage(messageDto))
	{
	
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	@PutMapping(value="/updatemessage")
	public ResponseEntity<String>updateMessage(@ModelAttribute MessageDto messageDto)
	{
		messageDto.setCreatedAt(new Date());
	if(messageService.updateMessage(messageDto))
	{
		messageService.updateMessage(messageDto);
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}
	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	
	@GetMapping("/messageContact/{iduser}/{idcontact}")
	ResponseEntity<List<MessageDto>> messageContact(@PathVariable Long iduser,@PathVariable long idcontact) {
	    return ResponseEntity.status(HttpStatus.OK).body(messageService.messageContact(iduser, idcontact));
	}
	
	@GetMapping("/listemessage")
	ResponseEntity<List<MessageDto>> listeMessageDtos() {
	    return ResponseEntity.status(HttpStatus.OK).body(messageService.listeMessageDtos());
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String>deleteMessage(@PathVariable Long id)
	{
	if(messageService.deleteMessage(id))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}

}
