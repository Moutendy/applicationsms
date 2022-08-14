package excel.example.sms.controllers;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import excel.example.sms.dto.ActualiterDto;
import excel.example.sms.services.ActualiterService;

@RestController
public class ActuController { 

	
	@Autowired
	ActualiterService actualiterService;
	
	@PostMapping(value="/sendActu", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces =  { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String>sendActu(@ModelAttribute ActualiterDto actualiterDto,@RequestParam("file")MultipartFile multipart) throws IOException
	{
		actualiterDto.setFileName(multipart.getOriginalFilename());
		
		actualiterDto.setFileType(multipart.getContentType());
		
		actualiterDto.setImageData(multipart.getBytes());
		
	if(actualiterService.creationActualiter(actualiterDto))
	{
	
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	@PutMapping(value="/updateActu", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces =  { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String>updateActu(@RequestBody ActualiterDto actualiterDto,@RequestParam("file")MultipartFile multipart) throws IOException
	{
actualiterDto.setFileName(multipart.getOriginalFilename());
		
		actualiterDto.setFileType(multipart.getContentType());
		
		actualiterDto.setImageData(multipart.getBytes());
	if(actualiterService.updateActualitere(actualiterDto))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}
	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	
	@GetMapping("/actueContact/{iduser}/{idcontact}")
	ResponseEntity<List<ActualiterDto>> actueContact(@PathVariable Long iduser,@PathVariable long idcontact) {
	    return ResponseEntity.status(HttpStatus.OK).body(actualiterService.listeActualiter(iduser, idcontact));
	}
	

	
	@DeleteMapping(value="/deleteActualiter/{id}")
	public ResponseEntity<String>deleteActualiter(@PathVariable Long id)
	{
	if(actualiterService.deleteActualiter(id))
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}

	
	@GetMapping(value="actualitecontact/{iduser}/{idcontact}")
	List<ActualiterDto> listeActualiterModel(@PathVariable Long idcontact,@PathVariable Long iduser)
	{
		return actualiterService.listeActualiter(idcontact, iduser);
	}
	
	
}
  