package excel.example.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.sms.model.UsersModel;

@Repository
public interface UserReposytory extends JpaRepository<UsersModel, Long>{
	
	

}
