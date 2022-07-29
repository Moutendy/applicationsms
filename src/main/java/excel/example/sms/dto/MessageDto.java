package excel.example.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
	private Long id;
	private String Message;
	private UserDto useremetteur;
	private String destinataire;

}
