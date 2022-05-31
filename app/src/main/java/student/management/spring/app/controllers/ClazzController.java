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

import student.management.spring.app.entities.Clazz;
import student.management.spring.app.services.ClazzService;
import student.management.spring.app.services.GradeService;

@Controller
@RequestMapping("/classes")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    
    @Autowired
    private GradeService gradeService;
    
    @GetMapping
    public String getClazzs(Model model){
        model.addAttribute("title", " Quản lý lớp");
        model.addAttribute("classes",clazzService.getAllClazzes());
        model.addAttribute("grades",gradeService.getAllGrades());
        model.addAttribute("classModelAttribute",new Clazz());
        return "classes";
    }
    @PostMapping
    public String createClazz(@ModelAttribute Clazz clazz, Model model){
   
        clazzService.saveClazz(clazz);
        return "redirect:/classes";
        
    }
    @PutMapping("/{id}")
    public String updateClazz(@PathVariable int id, @ModelAttribute Clazz clazz){
        System.out.println(clazz);
        clazzService.updateClazz(clazz, id);
        return "redirect:/classes";
    }
    @DeleteMapping("/{id}")
    public String deleteClazz(@PathVariable int id){
        clazzService.deleteClazzById(id);
        return "redirect:/classes";
    }
}
