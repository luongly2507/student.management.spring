package student.management.spring.app.services;

import java.util.List;


import student.management.spring.app.entities.Subject;

public interface SubjectService {
    public Subject saveSubject(Subject subject);
    public List<Subject> getAllSubjects();
    public Subject getSubjectById(int id);
    public void updateSubject(Subject subject, int id);
    public void deleteSubjectById(int id);
}
