package excel.example.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACTUALITE")
public class ActualiterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;
	
	@Column(name = "actu")
	private String actu;
	
	@ManyToOne
	@JoinColumn(name="USER_Id")
	private UsersModel userid;
	
	@ManyToOne
	@JoinColumn(name = "CONRACT_ID")
	private ContactModel contactid;
	
	@CreationTimestamp
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	 @Lob
	 @Column(name = "IMAGE_PROFIL", nullable = true)
	 private byte[] imageData;
	 
	 @Column(name = "FILE_NAME", nullable = true)
	 private String fileName;
	 
	 @Column(name = "FILE_TYPE", nullable = true)
	 private String fileType;
}
