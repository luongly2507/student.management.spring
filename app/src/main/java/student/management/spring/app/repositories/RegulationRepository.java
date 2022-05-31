package student.management.spring.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.management.spring.app.entities.Regulation;

@Repository
public interface RegulationRepository extends JpaRepository<Regulation,Integer>{

    Optional<Regulation> findByName(String string);
    
}
