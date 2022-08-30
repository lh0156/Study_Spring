package com.oraclejava.day5.mapper;

import com.oraclejava.day5.entity.Kbo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KboMapper {

    List<Kbo> selectAll();

    List<Kbo> searchAway(String name);

    List<Kbo> searchAwayHome(
            String awayName,
            String homeName);

    List<Kbo> searchInWinner(List<String> winners);

    void update(Kbo kbo);

    void insert(Kbo kbo);

    void delete(int teamNo);
}
