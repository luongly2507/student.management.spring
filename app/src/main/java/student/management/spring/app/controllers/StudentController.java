package student.management.spring.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import student.management.spring.app.entities.Student;
import student.management.spring.app.services.ClazzService;
import student.management.spring.app.services.SemesterService;
import student.management.spring.app.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private SemesterService semesterService;


    @GetMapping
    public String getStudent(Model model){
        model.addAttribute("title", " Quản lý học sinh");
        model.addAttribute("classes",studentService.getAllStudents());
        model.addAttribute("classes",clazzService.getAllClazzes());
        model.addAttribute("semesters",semesterService.getAllSemesters());
        model.addAttribute("studentModelAttribute",new Student());
        return "students";
    }
}
