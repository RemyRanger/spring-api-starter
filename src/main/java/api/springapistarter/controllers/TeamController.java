package api.springapistarter.controllers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.openapitools.api.TeamsApi;
import org.openapitools.model.TeamOut;
import org.openapitools.model.TeamIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import api.springapistarter.adapters.persistance.model.Team;
import api.springapistarter.controllers.mapper.TeamMapper;
import api.springapistarter.services.ITeamService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TeamController implements TeamsApi {

    private final ITeamService teamService;

    private final TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);
    
    @Override
    public ResponseEntity<TeamOut> createTeam(TeamIn teamIn) {
        return ResponseEntity.ok(teamMapper.teamToTeamOut(teamService.createTeam(teamMapper.teamInToTeam(teamIn))));
    }

    @Override
    public ResponseEntity<Void> deleteTeam(Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<TeamOut> getTeam(Long id) {
        final Optional<Team> optTeam = teamService.getTeam(id);

        if (!optTeam.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(teamMapper.teamToTeamOut(optTeam.get()));
    }

    @Override
    public ResponseEntity<List<TeamOut>> listTeams() {
        return ResponseEntity.ok(teamMapper.teamsToTeamOuts(teamService.listTeams()));
    }

    @Override
    public ResponseEntity<Void> updateTeam(Long id, TeamIn teamIn) {
        teamService.updateTeam(id, teamMapper.teamInToTeam(teamIn));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
