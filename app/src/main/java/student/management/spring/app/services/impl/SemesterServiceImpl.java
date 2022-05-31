package student.management.spring.app.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Semester;
import student.management.spring.app.repositories.SemesterRepository;
import student.management.spring.app.services.SemesterService;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService{

    @Autowired
    private SemesterRepository semesterRepository;

    @Override
    public Semester saveSemester(Semester semester) {
        if (semesterRepository.existsByName(semester.getName())){
            return null;
        }
        return semesterRepository.save(semester);
    }

    @Override
    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester getSemesterById(int id) {
        return semesterRepository.findById(id).get();
    }

    @Override
    public void updateSemester(Semester semester, int id) {
        Semester newSemester = semesterRepository.findById(id).get();
        if (!semester.getName().equals(newSemester.getName()) && !semesterRepository.existsByName(semester.getName())){
            newSemester.setName(semester.getName());
        }
        semesterRepository.save(newSemester);
    }

    @Override
    public void deleteSemesterById(int id) {
        semesterRepository.deleteById(id);
    }
    
}
