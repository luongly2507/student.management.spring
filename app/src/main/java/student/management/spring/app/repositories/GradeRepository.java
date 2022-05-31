package student.management.spring.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Integer>{

    boolean existsByName(String name);

    Optional<Grade> findByName(String string);
    
}
