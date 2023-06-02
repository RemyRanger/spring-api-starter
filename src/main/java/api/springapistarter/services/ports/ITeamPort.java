package api.springapistarter.services.ports;

import java.util.List;
import java.util.Optional;

import api.springapistarter.adapters.persistance.model.Team;

public interface ITeamPort {

    Team save(Team entity);

    void deleteById(Long id);

    Optional<Team> findById(Long id);

    List<Team> findAllPaginated(Long pageSize, Long pageToken, String orderBy, Boolean sortDirDesc);

    void update(Long id, Team entity);
}
