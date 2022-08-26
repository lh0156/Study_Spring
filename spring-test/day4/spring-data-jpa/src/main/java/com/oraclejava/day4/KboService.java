package com.oraclejava.day4;

import com.oraclejava.day4.entity.Kbo;

import java.util.List;

public interface KboService {
    List<Kbo> findAll();
    List<Kbo> findByTeamA(String teamA);
    List<Kbo> findByTeamAAndTeamB(String teamA, String teamB);
}
