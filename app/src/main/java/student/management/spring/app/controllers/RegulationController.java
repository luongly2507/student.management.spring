package student.management.spring.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import student.management.spring.app.dto.UpdateRegulation;
import student.management.spring.app.services.RegulationsService;

@Controller
@RequestMapping("/regulations")
public class RegulationController {

    @Autowired
    private RegulationsService regulationService;
    @GetMapping
    public String getRegulations(Model model) {
        model.addAttribute("title", " Thay đổi quy định");
        model.addAttribute("minAge", regulationService.getMinAge());
        model.addAttribute("maxAge", regulationService.getMaxAge());
        model.addAttribute("passScore", regulationService.getPassScore());
        model.addAttribute("updateRegulation",new UpdateRegulation());
        model.addAttribute("classCount",regulationService.getClassCount());
        return "regulations";
    }
    @PutMapping
    public String updateRegulation(@ModelAttribute UpdateRegulation updateRegulation) {
        regulationService.updateRegulation(updateRegulation.getMinAge(), updateRegulation.getMaxAge(), updateRegulation.getPassScore(), updateRegulation.getClassCount());
        return "redirect:/regulations";
    }
}
