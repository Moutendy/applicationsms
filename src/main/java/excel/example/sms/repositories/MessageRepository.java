package excel.example.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.sms.model.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel,Long>{

}
