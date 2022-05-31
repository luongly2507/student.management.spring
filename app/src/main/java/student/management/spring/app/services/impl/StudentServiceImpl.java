package student.management.spring.app.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Student;
import student.management.spring.app.services.StudentService;

@Service                                                                                                                                                                                                                                                                                
@Transactional
public class StudentServiceImpl implements StudentService{

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(Student student, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		
	}
    
}
 