package seop.pratice.mvcWeb.repository;

import org.springframework.stereotype.Component;
import seop.pratice.mvcWeb.domain.Member;

import java.util.List;
import java.util.Optional;

@Component
public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
