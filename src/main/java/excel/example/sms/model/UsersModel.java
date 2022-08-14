package excel.example.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class UsersModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;

	 @Lob
	 @Column(name = "IMAGE_PROFIL", nullable = true)
	 private byte[] imageData;
	 

	 @Column(name = "FILE_NAME", nullable = true)
	 private String fileName;
	 
	 @Column(name = "FILE_TYPE", nullable = true)
	 private String fileType;
	
	
}
