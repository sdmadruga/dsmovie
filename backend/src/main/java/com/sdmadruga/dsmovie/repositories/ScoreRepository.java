package com.sdmadruga.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdmadruga.dsmovie.etities.Score;
import com.sdmadruga.dsmovie.etities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{


}
