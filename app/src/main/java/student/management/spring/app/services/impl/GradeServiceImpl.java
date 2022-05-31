package student.management.spring.app.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Grade;
import student.management.spring.app.repositories.GradeRepository;
import student.management.spring.app.services.GradeService;

@Service
@Transactional
public class GradeServiceImpl implements GradeService{

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade saveGrade(Grade grade) {
        if (gradeRepository.existsByName(grade.getName())){
            return null;
        }
        return gradeRepository.save(grade);
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade getGradeById(int id) {
        return gradeRepository.findById(id).get();
    }

    @Override
    public void updateGrade(Grade grade, int id) {
        Grade newGrade = gradeRepository.findById(id).get();
        if (!grade.getName().equals(newGrade.getName()) && !gradeRepository.existsByName(grade.getName())){
            newGrade.setName(grade.getName());
        }
        gradeRepository.save(newGrade);
    }

    @Override
    public void deleteGradeById(int id) {
        gradeRepository.deleteById(id);
    }
    
}
