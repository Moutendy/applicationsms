package excel.example.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.sms.constante.Constante;

@RestController
public class SimpleEmailExampleController {

    @Autowired
    private JavaMailSender emailSender;
    
	 @ResponseBody
	    @RequestMapping("/sendSimpleEmail")
	    public String sendSimpleEmail() {

	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setTo(Constante.FRIEND_EMAIL);
	        message.setSubject("Test Simple Email");
	        message.setText("Hello, Im testing Simple Email");

	        // Send Message!
	        this.emailSender.send(message);

	        return "Email Sent!";
	    }
}
