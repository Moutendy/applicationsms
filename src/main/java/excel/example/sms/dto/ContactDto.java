package excel.example.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

	Long id;
	private UserDto userdestinataire;
    
    private String  namecontact;
}
