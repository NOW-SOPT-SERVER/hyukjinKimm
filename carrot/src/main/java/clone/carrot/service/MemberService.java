package clone.carrot.service;

import clone.carrot.doamin.Member;
import clone.carrot.doamin.dto.MemberCreateDto;
import clone.carrot.doamin.dto.MemberFindDto;
import clone.carrot.exception.NotFoundException;
import clone.carrot.exception.message.ErrorMessage;
import clone.carrot.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }




}
