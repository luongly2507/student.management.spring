package student.management.spring.app.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Score;
import student.management.spring.app.services.ScoreService;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService{

	@Override
	public Score saveScore(Score score) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Score> getAllScores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score getScoreById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateScore(Score score, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteScoreById(int id) {
		// TODO Auto-generated method stub
		
	}
    
}
