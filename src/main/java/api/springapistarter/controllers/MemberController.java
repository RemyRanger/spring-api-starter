package api.springapistarter.controllers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.openapitools.api.MembersApi;
import org.openapitools.model.MemberOut;
import org.openapitools.model.PaginatedMembers;
import org.openapitools.model.MemberIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import api.springapistarter.adapters.persistance.model.Member;
import api.springapistarter.controllers.mapper.MemberMapper;
import api.springapistarter.services.IMemberService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberController implements MembersApi {

    private final IMemberService memberService;

    private final MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);
    
    @Override
    public ResponseEntity<MemberOut> createMember(MemberIn memberIn) {
        return ResponseEntity.ok(memberMapper.memberToMemberOut(memberService.createMember(memberMapper.memberInToMember(memberIn))));
    }

    @Override
    public ResponseEntity<Void> deleteMember(Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MemberOut> getMember(Long id) {
        final Optional<Member> optMember = memberService.getMember(id);

        if (!optMember.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(memberMapper.memberToMemberOut(optMember.get()));
    }

    @Override
    public ResponseEntity<PaginatedMembers> listMembers(Long pageSize, Long pageToken, String orderBy, Boolean sortDirDesc) {

        final List<Member> memberList = memberService.listMembers(pageSize, pageToken, orderBy, sortDirDesc);

        final PaginatedMembers paginatedMembers = new PaginatedMembers();
        paginatedMembers.setMembers(memberMapper.membersToMemberOuts(memberList));

        return ResponseEntity.ok(paginatedMembers);
    }

    @Override
    public ResponseEntity<Void> updateMember(Long id, MemberIn memberIn) {
        memberService.updateMember(id, memberMapper.memberInToMember(memberIn));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
