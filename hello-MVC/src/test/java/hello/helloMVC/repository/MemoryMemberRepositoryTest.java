package hello.helloMVC.repository;

import hello.helloMVC.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();;
    }

    @Test
    public void save() {

        //given
        Member member = new Member();
        member.setName("spring");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        Long id = result.getId();
        String name = result.getName();

        System.out.println("id: " + id);
        System.out.println("name = " + name);

    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("yunseop1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("yunseop2");
        repository.save(member2);

        //when
        Member member = repository.findByName("yunseop1").get();
        System.out.println(member.getId());
        System.out.println(member.getName());

        //than
    }

    @Test
    public void findByAll() {
        //given
        Member member = new Member();
        member.setName("하하");
        repository.save(member);

        Member member1 = new Member();
        member.setName("하하2");
        repository.save(member1);

        Member member2 = new Member();
        member.setName("하하3");
        repository.save(member2);

        Member member3 = new Member();
        member.setName("하하4");
        repository.save(member3);

        Member member4 = new Member();
        member.setName("하하5");
        repository.save(member4);


        List<Member> all = repository.findAll();

        for (Member member5 : all) {
            Long id = member5.getId();
            String name = member5.getName();

            System.out.println("id: " + id + " name: " + name);

        }


        //when

        //then


    }

}