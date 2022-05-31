package student.management.spring.app.services;

import java.util.List;

import student.management.spring.app.entities.Student;

public interface StudentService {
      public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public void updateStudent(Student student, int id);
    public void deleteStudentById(int id);
}
