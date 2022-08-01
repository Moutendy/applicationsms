package excel.example.sms.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="image_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	
	@Column(name = "picByte", length = 1000)
	private byte[] picByte;
}
