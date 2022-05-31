package student.management.spring.app.services;

import java.util.List;

import student.management.spring.app.entities.ClazzStudent;

public interface ClazzStudentService {
    public ClazzStudent saveClazzStudent(ClazzStudent clazzStudent); 
    public List<ClazzStudent> getAllClazzStudents();
    public ClazzStudent getClazzStudentById(int id);
    public void updateClazzStudent(ClazzStudent clazzStudent, int id);
    public void deleteClazzStudentById(int id);
}
