package student.management.spring.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,Integer>{

    boolean existsByName(String name);
    
}
