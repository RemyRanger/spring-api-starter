package api.springapistarter.services;

import java.util.List;
import java.util.Optional;

import api.springapistarter.adapters.persistance.model.Team;

public interface ITeamService {

    Team createTeam(Team entity);

    void deleteTeam(Long id);

    Optional<Team> getTeam(Long id);

    List<Team> listTeams();

    void updateTeam(Long id, Team entity);

}
