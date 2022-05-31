package student.management.spring.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.ClazzStudent;

@Repository
public interface ClazzStudentRepository extends JpaRepository<ClazzStudent,Integer>{
    
}
