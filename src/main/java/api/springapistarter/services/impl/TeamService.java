package api.springapistarter.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import api.springapistarter.adapters.persistance.model.Team;
import api.springapistarter.services.ITeamService;
import api.springapistarter.services.ports.ITeamPort;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamService implements ITeamService {

    private final ITeamPort teamAdapter;

    @Override
    public Team createTeam(Team entity) {
        return teamAdapter.save(entity);
    }

    @Override
    public void deleteTeam(Long id) {
        teamAdapter.deleteById(id);
    }

    @Override
    public Optional<Team> getTeam(Long id) {
        return teamAdapter.findById(id);
    }

    @Override
    public List<Team> listTeams() {
        return teamAdapter.findAll();
    }

    @Override
    public void updateTeam(Long id, Team entity) {
        if (!teamAdapter.existsById(id)) {
            throw new DataIntegrityViolationException("Team not found");
        }

        teamAdapter.update(id, entity);
    }

}
