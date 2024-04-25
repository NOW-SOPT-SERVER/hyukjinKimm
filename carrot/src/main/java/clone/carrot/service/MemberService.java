package clone.carrot.service;

import clone.carrot.doamin.Member;
import clone.carrot.doamin.dto.MemberCreateDto;
import clone.carrot.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public String createMember(
            final MemberCreateDto createDto
            ) {
        Member member = Member.create(createDto.name());
        memberRepository.save(member);
        return member.getId().toString();
    }


}
