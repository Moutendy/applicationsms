package excel.example.sms.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualiterDto {

	private Long id;
	private String actu;
	private UserDto userid;
	private ContactDto contactid;
	private Date createdAt;

	private byte[] imageData;
	private String fileName;
	private String fileType;
}
