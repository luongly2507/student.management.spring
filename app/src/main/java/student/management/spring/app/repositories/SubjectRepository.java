package student.management.spring.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer>{

    List<Subject> findByName(String name);
    
}
