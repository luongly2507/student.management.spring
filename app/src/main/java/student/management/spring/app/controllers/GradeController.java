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
import student.management.spring.app.services.GradeService;

@Controller
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    
    @GetMapping
    public String getGrades(Model model){
        model.addAttribute("title", " Quản lý khối");
        model.addAttribute("grades",gradeService.getAllGrades());
        model.addAttribute("gradeModelAttribute",new Grade());
        return "grades";
    }
    @PostMapping
    public String createGrade(@ModelAttribute Grade grade, Model model){
        gradeService.saveGrade(grade);
        return "redirect:/grades";
        
    }
    @PutMapping("/{id}")
    public String updateGrade(@PathVariable int id, @ModelAttribute Grade grade){
        gradeService.updateGrade(grade, id);
        return "redirect:/grades";
    }
    @DeleteMapping("/{id}")
    public String deleteGrade(@PathVariable int id){
        gradeService.deleteGradeById(id);
        return "redirect:/grades";
    }
}
