package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {

        //given (주어짐)
        Member hello = new Member("hello", 20);

        //when (실행)
        Member saveMember = memberRepository.save(hello);

        //then (결과)
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll() {
        //given
        Member member = new Member("키키", 30);
        Member member1 = new Member("쿠쿠", 20);
        Member member2 = new Member("코코", 40);

        memberRepository.save(member);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> all = memberRepository.findAll();

        //then
        assertThat(all.size()).isEqualTo(3);
        assertThat(all).contains(member, member1, member2);
    }
}
