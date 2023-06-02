package api.springapistarter.adapters.persistance;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Component;

import api.springapistarter.adapters.persistance.model.Member;
import api.springapistarter.adapters.persistance.repo.MemberRepository;
import api.springapistarter.services.ports.IMemberPort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MemberAdapter implements IMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member entity) {
        return memberRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return IteratorUtils.toList(memberRepository.findAll().iterator());
    }

    @Override
    public void update(Long id, Member entity) {
        entity.setId(id);
        memberRepository.save(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return memberRepository.existsById(id);
    }
    
    @Override
    public long countMembersByTeamId(Long id) {
        return memberRepository.countMembersByTeamId(id);
    }
}
