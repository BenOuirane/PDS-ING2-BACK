package com.application.aled.repository;

/**
 * Class: ScoreRepository
 * @author: BEN OUIRANE Hajer
 */


import com.application.aled.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ScoreRepository extends JpaRepository<Score,Long> {

    List<Score>findAll();
    Score save(Score s);
}
