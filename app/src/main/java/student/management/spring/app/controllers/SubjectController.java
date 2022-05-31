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

import student.management.spring.app.entities.Subject;
import student.management.spring.app.services.GradeService;
import student.management.spring.app.services.SubjectService;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private GradeService gradeService;
    
    @GetMapping
    public String getSubjects(Model model){
        model.addAttribute("title", " Quản lý môn học");
        model.addAttribute("subjects",subjectService.getAllSubjects());
        model.addAttribute("grades",gradeService.getAllGrades());
        model.addAttribute("subjectModelAttribute",new Subject());
        return "subjects";
    }
    @PostMapping
    public String createSubject(@ModelAttribute Subject subject, Model model){
   
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
        
    }
    @PutMapping("/{id}")
    public String updateSubject(@PathVariable int id, @ModelAttribute Subject subject){
        System.out.println(subject);
        subjectService.updateSubject(subject, id);
        return "redirect:/subjects";
    }
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable int id){
        subjectService.deleteSubjectById(id);
        return "redirect:/subjects";
    }
}