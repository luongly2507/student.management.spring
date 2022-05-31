package student.management.spring.app.services;

import java.util.List;

import student.management.spring.app.entities.Semester;

public interface SemesterService {
      public Semester saveSemester(Semester semester);
    public List<Semester> getAllSemesters();
    public Semester getSemesterById(int id);
    public void updateSemester(Semester semester, int id);
    public void deleteSemesterById(int id);
}
