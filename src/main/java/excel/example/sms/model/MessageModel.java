package excel.example.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "MESSAGE")
public class MessageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;
	
	@Column(name = "message")
	private String message;
	
	@ManyToOne
	@JoinColumn(name="USER_Id")
	private UsersModel userid;
	
	@ManyToOne
	@JoinColumn(name = "CONRACT_ID")
	private ContactModel contactid;
	
	@CreationTimestamp
	@Column(name = "CREATED_AT")
	private Date createdAt;
}
