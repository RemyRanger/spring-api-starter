package api.springapistarter.adapters.persistance;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Component;

import api.springapistarter.adapters.persistance.model.Team;
import api.springapistarter.adapters.persistance.repo.TeamRepository;
import api.springapistarter.services.ports.ITeamPort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TeamAdapter implements ITeamPort {

    private final TeamRepository teamRepository;

    @Override
    public Team save(Team entity) {
        return teamRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> findAll() {
        return IteratorUtils.toList(teamRepository.findAll().iterator());
    }

    @Override
    public void update(Long id, Team entity) {
        entity.setId(id);
        teamRepository.save(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return teamRepository.existsById(id);
    }
}
