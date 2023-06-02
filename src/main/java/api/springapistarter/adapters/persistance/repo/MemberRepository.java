package api.springapistarter.adapters.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import api.springapistarter.adapters.persistance.model.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Query(value = "SELECT * FROM member ORDER BY :orderBy OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY", nativeQuery = true)
	List<Member> findAllPaginated(@Param("size") int size, @Param("orderBy") String orderBy, @Param("offset") int offset);

}
