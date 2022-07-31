package excel.example.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.sms.model.ActualiterModel;

@Repository
public interface ActualiterRepository extends JpaRepository<ActualiterModel, Long>{

	@Query(value="select a From ActualiterModel a where a.userid.id=:iduser and a.contactid.id=:idcontact order by createdAt ")
	List<ActualiterModel> listeActualiterModel(@Param("idcontact")Long idcontact,@Param("iduser")Long iduser);
}
