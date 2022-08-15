//package excel.example.sms.config;
//
//import java.util.Properties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import excel.example.sms.constante.Constante;
//
//@Configuration
//public class EmailConfig {
//	
//	@Bean
//	public JavaMailSender  getJavaMailSender()
//	{
//		 JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	        mailSender.setHost("smtp.gmail.com");
//	        mailSender.setPort(25);
//	        
//	        mailSender.setUsername(Constante.MY_EMAIL);
//	        mailSender.setPassword(Constante.MY_PASSWORD);
//
//	        Properties props = mailSender.getJavaMailProperties();
//	        props.put("mail.transport.protocol", "smtp");
//	        props.put("mail.smtp.auth", "true");
//	        props.put("mail.smtp.starttls.enable", "true");
//	        props.put("mail.debug", "true");
//	        
//	        return mailSender;
//	}
//
//}