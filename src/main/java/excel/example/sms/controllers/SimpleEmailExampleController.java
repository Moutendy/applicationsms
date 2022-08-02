package excel.example.sms.controllers;

import java.io.File;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.sms.constante.Constante;
import excel.example.sms.services.EmailService;

@RestController
public class SimpleEmailExampleController {

	@Autowired
	private EmailService emailService;

	@ResponseBody
	@RequestMapping("/sendSimpleEmail")
	public String sendSimpleEmail() {

		emailService.sendSimpleMessage("noreply@baeldung.com",Constante.FRIEND_EMAIL, "Test Simple Email", "Hello, Guichet R_H");

		return "Email Sent!";
	}
	
	@ResponseBody
	@RequestMapping("/sendSimpleEmailHtml")
	public String sendSimpleEmailHtml() throws MessagingException {

		emailService.sendMessageWithHtml();

		return "Email Sent!";
	}
	
	

	@ResponseBody
	@RequestMapping("/sendSimpleEmailAttachement")
	public String sendSimpleEmailAttachement() throws MessagingException {
 File file=new File("Downloads/conceptionguichet_Rh%20(1).pdf");
		emailService.sendMessageWithAttachment("noreply@baeldung.com",Constante.FRIEND_EMAIL,"Hello, Im testing Simple Email",file.getName());

		return "Email Sent!";
	}
}
