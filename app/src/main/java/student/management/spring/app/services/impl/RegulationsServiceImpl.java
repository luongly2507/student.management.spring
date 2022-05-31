package student.management.spring.app.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Regulation;
import student.management.spring.app.repositories.RegulationRepository;
import student.management.spring.app.services.RegulationsService;

@Service
@Transactional
public class RegulationsServiceImpl implements RegulationsService{
    @Autowired
    private RegulationRepository regulationRepository;

    @Override
    public int getMinAge() {
       return Integer.parseInt(regulationRepository.findByName("minAge").get().getValue());
    }

    @Override
    public int getMaxAge() {
        return Integer.parseInt(regulationRepository.findByName("maxAge").get().getValue());
    }

    @Override
    public double getPassScore() {
        return Double.parseDouble(regulationRepository.findByName("passScore").get().getValue());
    }

    @Override
    public void updateRegulation(String minAge, String maxAge, String passScore,String classCount) {
        Regulation minAgeRegulation = regulationRepository.findByName("minAge").get();
        Regulation maxAgeRegulation = regulationRepository.findByName("maxAge").get();
        Regulation passScoreRegulation = regulationRepository.findByName("passScore").get();
        Regulation classCountRegulation = regulationRepository.findByName("classCount").get();
        minAgeRegulation.setValue(minAge);
        maxAgeRegulation.setValue(maxAge);
        passScoreRegulation.setValue(passScore);
        classCountRegulation.setValue(classCount);
        regulationRepository.save(minAgeRegulation);
        regulationRepository.save(maxAgeRegulation);
        regulationRepository.save(passScoreRegulation);
    }

    @Override
    public int getClassCount() {
        return Integer.parseInt(regulationRepository.findByName("classCount").get().getValue());
    }
    
}
