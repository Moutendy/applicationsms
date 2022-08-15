package excel.example.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	
     Long id;
	

	private String name;
	

	private String email;
	

	private String password;
	
	private byte[] imageData;
	
	private String fileName;
	
	private String fileType;
	
}
