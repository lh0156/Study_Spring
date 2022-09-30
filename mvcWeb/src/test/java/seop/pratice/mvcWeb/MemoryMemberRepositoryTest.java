package seop.pratice.mvcWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seop.pratice.mvcWeb.domain.Member;
import seop.pratice.mvcWeb.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {

        Member member = new Member();
        member.setName("윤섭");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findByName() {

        Member member = new Member();
        member.setName("윤섭");

        repository.save(member);

        Member member1 = repository.findByName("윤섭").get();

        assertThat(member).isEqualTo(member1);

    }

    @Test
    public void findByAll() {

        Member member = new Member();
        Member member2 = new Member();
        Member member3 = new Member();

        member.setName("윤섭");
        repository.save(member);

        member2.setName("유미");
        repository.save(member2);

        member3.setName("혜인");
        repository.save(member3);


        List<Member> all = repository.findAll();
        assertThat(all.size()).isEqualTo(3);

    }
}
