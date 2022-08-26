package com.oraclejava.day4;

import com.oraclejava.day4.entity.Kbo;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

public interface KboRepository
        extends CrudRepository<Kbo, Long> {
    //앞에 findBy를 붙이면 뒤에 오는 단어가 where절의 column으로 걸린다.
    List<Kbo> findByTeamA(String teamA);
    List<Kbo> findByTeamAAndTeamB(String teamA, String teamB);

    // 승리팀은 전부 'Doosan'으로 변경
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Modifying
    @Query("UPDATE Kbo k"
        + " SET k.winner = :winner")
    public int setWinner(@Param("winner") String winner);

}
