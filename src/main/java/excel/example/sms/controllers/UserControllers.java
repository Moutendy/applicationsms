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

import excel.example.sms.dto.UserDto;
import excel.example.sms.services.UserService;

@RestController
public class UserControllers {

	@Autowired
	UserService userService;
	
	@PostMapping(value="/userajouter")
	public ResponseEntity<String>ajouterUser(@RequestBody UserDto user)
	{
	if(userService.creationUser(user))
	{
		userService.creationUser(user);
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	
	@GetMapping("/users")
	ResponseEntity<List<UserDto>> listeusers() {
	    return ResponseEntity.status(HttpStatus.OK).body(userService.listeUserDtos());
	}
	
	@PutMapping(value="/userajouter")
	public ResponseEntity<String>updateUser(@RequestBody UserDto user)
	{
	if(userService.updateUser(user))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	

	@DeleteMapping(value="/userdelete")
	public ResponseEntity<String>deleteUser(@PathVariable Long id)
	{
	if(userService.deleteUser(id))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
}
