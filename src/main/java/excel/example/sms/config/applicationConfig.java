package excel.example.sms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class applicationConfig implements WebMvcConfigurer{

	   public void addCorsMappings(CorsRegistry registry) {
	        WebMvcConfigurer.super.addCorsMappings(registry);
	        //L'activation de CORS(resource d'origin croiser)
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:8100")
	                .allowedMethods("GET","POST","PATCH","PUT");
	        //origine autoriser et methodes autoriser


	    }
}
