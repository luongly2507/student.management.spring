package student.management.spring.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import student.management.spring.app.entities.Grade;
import student.management.spring.app.entities.Semester;
import student.management.spring.app.services.SemesterService;

@Controller
@RequestMapping("/semesters")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    
    @GetMapping
    public String getGrades(Model model){
        model.addAttribute("title", " Quản lý học kì");
        model.addAttribute("semesters",semesterService.getAllSemesters());
        model.addAttribute("semesterModelAttribute",new Grade());
        return "semesters";
    }
    @PostMapping
    public String createGrade(@ModelAttribute Semester semester, Model model){
        semesterService.saveSemester(semester);
        return "redirect:/semesters";
        
    }
    @PutMapping("/{id}")
    public String updateGrade(@PathVariable int id, @ModelAttribute Semester semester){
        semesterService.updateSemester(semester, id);
        return "redirect:/semesters";
    }
    @DeleteMapping("/{id}")
    public String deleteGrade(@PathVariable int id){
        semesterService.deleteSemesterById(id);
        return "redirect:/semesters";
    }
}
