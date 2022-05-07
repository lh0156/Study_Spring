package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given 이런게 주어졌을 때
        Member member = new Member(1L, "엄윤섭", Grade.BASIC);

        //when 이 상황에
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //than 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
