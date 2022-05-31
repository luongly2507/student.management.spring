package student.management.spring.app.services.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.management.spring.app.entities.Clazz;
import student.management.spring.app.entities.Grade;
import student.management.spring.app.repositories.ClazzRepository;
import student.management.spring.app.repositories.GradeRepository;
import student.management.spring.app.services.ClazzService;

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    private ClazzRepository clazzRepository;
	@Autowired
    private GradeRepository gradeRepository;

	@Override
	public Clazz saveClazz(Clazz clazz) {
		if (clazz.getGrade() == null) {
			return null;
		}
		List<Clazz> clazzList = clazzRepository.findByName(clazz.getName());
		for (int i =0; i < clazzList.size(); i++) {
			if (clazzList.get(i).getGrade().getId() == clazz.getGrade().getId()) {
				return null;
			}
		}
		clazz.setGrade(gradeRepository.findById(clazz.getGrade().getId()).get());
		return clazzRepository.save(clazz);
	}

	@Override
	public List<Clazz> getAllClazzes() {
	
		return clazzRepository.findAll();
	}

	@Override
	public Clazz getClazzById(int id) {
		
		return clazzRepository.findById(id).get();
	}

	@Override
	public void updateClazz(Clazz clazz, int id) {
		List<Clazz> clazzList = clazzRepository.findByName(clazz.getName());
		for (int i =0; i < clazzList.size(); i++) {
			if (clazzList.get(i).getGrade().getId() == clazz.getGrade().getId()) {
				return;
			}
		}
        Clazz clazzUpdate = clazzRepository.findById(id).get();
        clazzUpdate.setName(clazz.getName());
        clazzUpdate.setGrade(clazz.getGrade());
        clazzUpdate.setClazzStudents(clazz.getClazzStudents());
		clazzRepository.save(clazzUpdate);
	}

	@Override
	public void deleteClazzById(int id) {
         Clazz clazzDelete = clazzRepository.findById(id).get();
        clazzRepository.deleteById(clazzDelete.getId());
		
	}


    
}
