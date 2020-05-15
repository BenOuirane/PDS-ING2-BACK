package com.application.aled.service;
/**
 * Class: ScoreServiceImpl
 * @author: BEN OUIRANE Hajer
 */


import com.application.aled.entity.Score;
import com.application.aled.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository repository;




    @Override
    public Score add(Score s) {
        return repository.save(s);
    }
}
