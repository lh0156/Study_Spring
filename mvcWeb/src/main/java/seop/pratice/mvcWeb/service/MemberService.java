package seop.pratice.mvcWeb.service;


import org.springframework.beans.factory.annotation.Autowired;
import seop.pratice.mvcWeb.domain.Member;
import seop.pratice.mvcWeb.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
