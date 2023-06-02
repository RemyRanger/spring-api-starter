package api.springapistarter.services.ports;

import java.util.List;
import java.util.Optional;

import api.springapistarter.adapters.persistance.model.Member;

public interface IMemberPort {

    long countMembersByTeamId(Long id);

    boolean existsById(Long id);

    Member save(Member entity);

    void deleteById(Long id);

    Optional<Member> findById(Long id);

    List<Member> findAllPaginated(Long pageSize, Long pageToken, String orderBy, Boolean sortDirDesc);

    void update(Long id, Member entity);
}
