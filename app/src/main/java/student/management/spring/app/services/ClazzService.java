package student.management.spring.app.services;

import java.util.List;

import student.management.spring.app.entities.Clazz;

public interface ClazzService {
    public Clazz saveClazz(Clazz clazz);
    public List<Clazz> getAllClazzes();
    public Clazz getClazzById(int id);
    public void updateClazz(Clazz clazz, int id);
    public void deleteClazzById(int id);
}
