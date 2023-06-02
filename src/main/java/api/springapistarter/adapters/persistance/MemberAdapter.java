package api.springapistarter.adapters.persistance;

import java.util.List;
import java.util.Optional;

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
    public List<Member> findAllPaginated(Long pageSize, Long pageToken, String orderBy, Boolean sortDirDesc) {
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

        return memberRepository.findAllPaginated(size, order, offset);
    }

    @Override
    public void update(Long id, Member entity) {
        entity.setId(id);
        memberRepository.save(entity);
    }
    
}
