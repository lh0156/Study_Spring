package hello.helloMVC.Service;

import hello.helloMVC.domain.Member;
import hello.helloMVC.repository.MemberRepository;
import hello.helloMVC.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    *  회원가입
    * */

    public Long join(Member member) {



    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                   throw new Illg
                });

    }



}
