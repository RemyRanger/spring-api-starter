package api.springapistarter.controllers.mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.MemberIn;
import org.openapitools.model.MemberOut;

import api.springapistarter.adapters.persistance.model.Member;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    Member memberInToMember(MemberIn in);

    MemberOut memberToMemberOut(Member in);

    List<MemberOut> membersToMemberOuts(List<Member> in);

    public static OffsetDateTime map(Instant value) {
        return value != null ? value.atOffset(ZoneOffset.UTC) : null;
    }
}
