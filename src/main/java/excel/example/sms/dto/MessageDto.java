package excel.example.sms.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
	private Long id;
	private String message;
	private UserDto userid;
	private ContactDto contactid;
	private Date createdAt;

}
