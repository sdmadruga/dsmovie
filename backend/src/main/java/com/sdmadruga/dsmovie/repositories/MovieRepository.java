package com.sdmadruga.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdmadruga.dsmovie.etities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
