package com.sdmadruga.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdmadruga.dsmovie.dto.MovieDTO;
import com.sdmadruga.dsmovie.dto.ScoreDTO;
import com.sdmadruga.dsmovie.etities.Movie;
import com.sdmadruga.dsmovie.etities.Score;
import com.sdmadruga.dsmovie.etities.User;
import com.sdmadruga.dsmovie.repositories.MovieRepository;
import com.sdmadruga.dsmovie.repositories.ScoreRepository;
import com.sdmadruga.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	@Autowired
	private MovieRepository movierepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore (ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		Movie movie = movierepository.findById(dto.getMovieId()).get();
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movierepository.save(movie);
		return new MovieDTO(movie);
	}
	
}
