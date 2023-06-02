package api.springapistarter.services;

import java.util.List;
import java.util.Optional;

import api.springapistarter.adapters.persistance.model.Member;

public interface IMemberService {

    Member createMember(Member entity);

    void deleteMember(Long id);

    Optional<Member> getMember(Long id);

    List<Member> listMembers();

    void updateMember(Long id, Member entity);

}
