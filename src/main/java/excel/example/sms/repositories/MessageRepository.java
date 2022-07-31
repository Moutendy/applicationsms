package excel.example.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.sms.model.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel,Long>{

	
	@Query(value="select m From MessageModel m where m.userid.id=:iduser and m.contactid.id=:idcontact ORDER BY createdAt DESC")
	List<MessageModel> messageContact(@Param("iduser")Long iduser,@Param("idcontact")Long idcontact);
}
