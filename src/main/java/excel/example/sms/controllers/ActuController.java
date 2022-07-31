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

import excel.example.sms.dto.ActualiterDto;
import excel.example.sms.services.ActualiterService;

@RestController
public class ActuController { 

	
	@Autowired
	ActualiterService actualiterService;
	
	@PostMapping(value="/sendActu")
	public ResponseEntity<String>sendActu(@RequestBody ActualiterDto actualiterDto)
	{
	if(actualiterService.creationActualiter(actualiterDto))
	{
	
		return ResponseEntity.status(HttpStatus.OK).body("OK");	
	}

	return  ResponseEntity.badRequest().body("Bad request");
		
	}
	
	@PutMapping(value="/updateActu")
	public ResponseEntity<String>updateActu(@RequestBody ActualiterDto actualiterDto)
	{
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

	
	
}
  