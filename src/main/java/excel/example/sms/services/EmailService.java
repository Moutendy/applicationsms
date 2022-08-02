package excel.example.sms.services;

import javax.mail.MessagingException;

public interface EmailService {
	
	void sendSimpleMessage(String from,String to,String sunject, String text);
	
	void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException;

	void sendMessageWithHtml() throws MessagingException;

}
