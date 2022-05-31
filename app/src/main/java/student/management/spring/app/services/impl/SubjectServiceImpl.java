package student.management.spring.app.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Subject;
import student.management.spring.app.repositories.SubjectRepository;
import student.management.spring.app.repositories.GradeRepository;
import student.management.spring.app.services.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectRepository subjectRepository;
	@Autowired
    private GradeRepository gradeRepository;

	@Override
	public Subject saveSubject(Subject subject) {
		if (subject.getGrade() == null) {
			return null;
		}
		List<Subject> subjectList = subjectRepository.findByName(subject.getName());
		for (int i =0; i < subjectList.size(); i++) {
			if (subjectList.get(i).getGrade().getId() == subject.getGrade().getId()) {
				return null;
			}
		}
		subject.setGrade(gradeRepository.findById(subject.getGrade().getId()).get());
		return subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getAllSubjects() {
	
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(int id) {
		
		return subjectRepository.findById(id).get();
	}

	@Override
	public void updateSubject(Subject subject, int id) {
		List<Subject> subjectList = subjectRepository.findByName(subject.getName());
		for (int i =0; i < subjectList.size(); i++) {
			if (subjectList.get(i).getGrade().getId() == subject.getGrade().getId()) {
				return;
			}
		}
        Subject subjectUpdate = subjectRepository.findById(id).get();
        subjectUpdate.setName(subject.getName());
        subjectUpdate.setGrade(subject.getGrade());
		subjectRepository.save(subjectUpdate);
	}

	@Override
	public void deleteSubjectById(int id) {
         Subject subjectDelete = subjectRepository.findById(id).get();
        subjectRepository.deleteById(subjectDelete.getId());
		
	}


    
}

