package api.springapistarter.adapters.persistance.repo;

import org.springframework.data.repository.CrudRepository;

import api.springapistarter.adapters.persistance.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
