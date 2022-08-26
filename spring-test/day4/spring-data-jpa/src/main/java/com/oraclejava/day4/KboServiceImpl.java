package com.oraclejava.day4;

import com.google.common.collect.Lists;
import com.oraclejava.day4.entity.Kbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("kboJpaService")
@Transactional
public class KboServiceImpl implements KboService{

    @Autowired
    private KboRepository kboRepository;

    @Override
    public List<Kbo> findAll() {
        return Lists.newArrayList(kboRepository.findAll());
    }

    @Override
    public List<Kbo> findByTeamA(String teamA) {
        return kboRepository.findByTeamA(teamA);
    }


}
