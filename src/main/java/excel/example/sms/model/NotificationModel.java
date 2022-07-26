package excel.example.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATION")
public class NotificationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;
	
    @Column(name = "statut")
    private boolean statut;
    
    @ManyToOne
    @JoinColumn(name="USER")
	private UsersModel userdestinataire;
    @ManyToOne
    @JoinColumn(name = "MESSAGE_NOTIFICATION")
	private MessageModel messagenotification;
}
