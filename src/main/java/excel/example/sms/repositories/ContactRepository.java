package excel.example.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.sms.model.ContactModel;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Long>{
	
	@Query(value = "SELECT u FROM ContactModel u where u.myid=:id ORDER BY id")
	List<ContactModel> findAllUsers(@Param("id")Long id); 
	
	
}
   