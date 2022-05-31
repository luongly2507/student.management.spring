package student.management.spring.app.services;

import java.util.List;

import student.management.spring.app.entities.Grade;

public interface GradeService {
    public Grade saveGrade(Grade grade);
    public List<Grade> getAllGrades();
    public Grade getGradeById(int id);
    public void updateGrade(Grade grade, int id);
    public void deleteGradeById(int id);
}
