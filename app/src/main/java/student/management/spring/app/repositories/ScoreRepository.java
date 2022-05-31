package student.management.spring.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Integer>{
    
}
