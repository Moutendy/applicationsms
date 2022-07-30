package excel.example.sms.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@PostMapping(value="/sendMessage")
	public void sendMessage()
	{
		
	}   

}
