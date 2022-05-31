package student.management.spring.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
