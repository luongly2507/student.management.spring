package student.management.spring.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("title", "Index");
        return "index";
    }
}
