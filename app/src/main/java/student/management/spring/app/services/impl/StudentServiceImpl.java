package student.management.spring.app.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Student;
import student.management.spring.app.repositories.StudentRepository;
import student.management.spring.app.services.StudentService;

@Service                                                                                                                                                                                                                                                                                
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void updateStudent(Student student, int id) {
		Student newStudent = studentRepository.findById(id).get();
		newStudent.setAddress(student.getAddress());
		newStudent.setName(student.getName());
		newStudent.setEmail(student.getEmail());
		newStudent.setBirthDate(student.getBirthDate());
		newStudent.setPhone(student.getPhone());
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);		
	}
    
}
 