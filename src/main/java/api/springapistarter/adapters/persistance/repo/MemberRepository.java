package api.springapistarter.adapters.persistance.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import api.springapistarter.adapters.persistance.model.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Query(value = "SELECT count(*) FROM member m WHERE m.team_id = :teamId", nativeQuery = true)
    long countMembersByTeamId(@Param("teamId") Long ID);

}
