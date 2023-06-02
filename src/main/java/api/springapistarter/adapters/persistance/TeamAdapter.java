package api.springapistarter.adapters.persistance;

import java.util.List;
import java.util.Optional;

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
    public List<Team> findAllPaginated(Long pageSize, Long pageToken, String orderBy, Boolean sortDirDesc) {
        int size = 10;
        int offset = 0;
        String order = "";

        if (pageSize != 0) {
            size = pageSize.intValue();
        }
        if (pageToken != 0) {
            offset = (pageToken.intValue() - 1) * size;
        }
        if (orderBy != null) {
            if (sortDirDesc == true) {
                order = orderBy + " desc";
            } else {
                order = orderBy + " asc";
            }
        }

        return teamRepository.findAllPaginated(size, order, offset);
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
