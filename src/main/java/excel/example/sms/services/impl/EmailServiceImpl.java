package excel.example.sms.services.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import excel.example.sms.constante.Constante;
import excel.example.sms.services.EmailService;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendSimpleMessage(String from,String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();


		 
		message.setFrom(from);
		message.setTo(to);
		message.setText(text);
		
		
		message.setSubject(subject);
		

     mailSender.send(message);

	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
		// TODO Auto-generated method stub
		
		MimeMessage message = mailSender.createMimeMessage();
	     
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    
	    helper.setFrom("noreply@baeldung.com");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);
	        
	    FileSystemResource file 
	      = new FileSystemResource(new File(pathToAttachment));
	    helper.addAttachment("Invoice", file);

	    mailSender.send(message);
		
	}
	
	@Override
	public void sendMessageWithHtml() throws MessagingException {
	
	MimeMessage mimeMessage = mailSender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
	String htmlMsg = "<table>"
			+ "<tr style='background-color:blue; color: #fff;'><th>Date Creation</th><th>Nom</th></tr>"
			+ "<tr style='color:#0000ff;'><th>02/08/2022</th><th>certificat medical</th></tr>"
			+ "</table>";
	//mimeMessage.setContent(htmlMsg, "text/html"); /** Use this or below line **/
	helper.setText(htmlMsg, true); // Use this or above line.
	helper.setTo(Constante.FRIEND_EMAIL);
	helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
	helper.setFrom(Constante.FRIEND_EMAIL);
	mailSender.send(mimeMessage);
	
	}

}
