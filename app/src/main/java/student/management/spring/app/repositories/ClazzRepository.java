package student.management.spring.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.Clazz;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz,Integer>{
   List<Clazz> findByName(String name);
}
