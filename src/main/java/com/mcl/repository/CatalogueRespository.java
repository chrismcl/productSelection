package com.mcl.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mcl.entity.Catalogue;
import java.util.List;

public interface CatalogueRespository extends JpaRepository<Catalogue, Integer> {
	@Query("select u from Catalogue u where u.category = ?1 and (u.locationId = ?2 or u.locationId is null)")
	List<Catalogue> findByCategoryAndLocationId(String category, String locationId);
}