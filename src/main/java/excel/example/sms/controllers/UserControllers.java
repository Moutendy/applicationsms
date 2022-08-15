package excel.example.sms.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import excel.example.sms.dto.UserDto;
import excel.example.sms.model.UsersModel;
import excel.example.sms.services.UserService;

@RestController
public class UserControllers {

	@Autowired
	UserService userService;
	
	@PostMapping(value="/userajouter", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces =  { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String>ajouterUser(@ModelAttribute UserDto user,@RequestParam("file")MultipartFile multipart) throws IOException
	{
		user.setFileName(multipart.getOriginalFilename());
		user.setFileType(multipart.getContentType());
		user.setImageData(multipart.getBytes());
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
	
	@PutMapping(value="/userupdate",consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces =  { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String>updateUser(@ModelAttribute UserDto user,@RequestParam("file")MultipartFile multipart) throws IOException
	{
		
		user.setFileName(multipart.getOriginalFilename());
		user.setFileType(multipart.getContentType());
		user.setImageData(multipart.getBytes());
	if(userService.updateUser(user))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	

	@DeleteMapping(value="/userdelete/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id)
	{
	if(userService.deleteUser(id))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	@GetMapping("/user/{id}")
	public Optional<UsersModel> profile(@PathVariable Long id)
	{
	
		return userService.profile(id);
	}
	
}
