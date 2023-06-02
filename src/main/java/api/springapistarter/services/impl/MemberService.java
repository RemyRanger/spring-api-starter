package api.springapistarter.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import api.springapistarter.adapters.persistance.model.Member;
import api.springapistarter.config.exception.TeamMembersFullException;
import api.springapistarter.services.IMemberService;
import api.springapistarter.services.ports.IMemberPort;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService implements IMemberService {

    private final IMemberPort memberAdapter;

    @Override
    public Member createMember(Member entity) {
        if (memberAdapter.countMembersByTeamId(entity.getTeamId()) >= 10) {
            throw new TeamMembersFullException();
        }

        return memberAdapter.save(entity);
    }

    @Override
    public void deleteMember(Long id) {
        memberAdapter.deleteById(id);
    }

    @Override
    public Optional<Member> getMember(Long id) {
        return memberAdapter.findById(id);
    }

    @Override
    public List<Member> listMembers(Long pageSize, Long pageToken, String orderBy, Boolean sortDirDesc) {
        return memberAdapter.findAllPaginated(pageSize, pageToken, orderBy, sortDirDesc);
    }

    @Override
    public void updateMember(Long id, Member entity) {
        if (!memberAdapter.existsById(id)) {
            throw new DataIntegrityViolationException("Member not found");
        }

        if (memberAdapter.countMembersByTeamId(entity.getTeamId()) >= 10) {
            throw new TeamMembersFullException();
        }

        memberAdapter.update(id, entity);
    }

}
