package api.springapistarter.adapters.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import api.springapistarter.adapters.persistance.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    @Query(value = "SELECT * FROM team ORDER BY :orderBy OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY", nativeQuery = true)
	List<Team> findAllPaginated(@Param("size") int size, @Param("orderBy") String orderBy, @Param("offset") int offset);

}
