package excel.example.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.sms.model.ImageModel;
@Repository
public interface ImageRepository extends JpaRepository<ImageModel,Long>{

	List<ImageModel> findByName(String name);
}
