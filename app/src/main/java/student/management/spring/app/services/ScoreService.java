package student.management.spring.app.services;

import java.util.List;

import student.management.spring.app.entities.Score;

public interface ScoreService {
      public Score saveScore(Score score);
    public List<Score> getAllScores();
    public Score getScoreById(int id);
    public void updateScore(Score score, int id);
    public void deleteScoreById(int id);
}
