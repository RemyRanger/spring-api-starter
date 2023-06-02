package api.springapistarter.controllers.mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.TeamIn;
import org.openapitools.model.TeamOut;

import api.springapistarter.adapters.persistance.model.Team;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

    Team teamInToTeam(TeamIn in);

    TeamOut teamToTeamOut(Team in);

    List<TeamOut> teamsToTeamOuts(List<Team> in);

    public static OffsetDateTime map(Instant value) {
        return value != null ? value.atOffset(ZoneOffset.UTC) : null;
    }
}
