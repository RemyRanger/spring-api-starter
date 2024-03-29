package api.springapistarter.services.ports;

import java.util.List;
import java.util.Optional;

import api.springapistarter.adapters.persistance.model.Team;

public interface ITeamPort {

    boolean existsById(Long id);

    Team save(Team entity);

    void deleteById(Long id);

    Optional<Team> findById(Long id);

    List<Team> findAll();

    void update(Long id, Team entity);
}
