package com.oraclejava.day4;

import com.oraclejava.day4.entity.Kbo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KboRepository
        extends CrudRepository<Kbo, Long> {
    //앞에 findBy를 붙이면 뒤에 오는 단어가 where절의 column으로 걸린다.
    List<Kbo> findByTeamA(String teamA);
    List<Kbo> findByTeamAAndTeamB(String teamA, String teamB);
}
