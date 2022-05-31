package student.management.spring.app.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import student.management.spring.app.entities.ClazzStudent;
import student.management.spring.app.services.ClazzStudentService;

@Service
@Transactional
public class ClazzStudentServiceImpl implements ClazzStudentService{

	@Override
	public ClazzStudent saveClazzStudent(ClazzStudent clazzStudent) {
		
		return null;
	}

	@Override
	public List<ClazzStudent> getAllClazzStudents() {
	
		return null;
	}

	@Override
	public ClazzStudent getClazzStudentById(int id) {
		
		return null;
	}

	@Override
	public void updateClazzStudent(ClazzStudent clazzStudent, int id) {
		
		
	}

	@Override
	public void deleteClazzStudentById(int id) {
		
		
	}
    
}
