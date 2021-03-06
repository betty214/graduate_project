package hello.hellospring.controller;

import hello.hellospring.domain.Majors;
import hello.hellospring.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MajorController {
    private final MajorService majorService;
    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }
    @GetMapping(value = "/majors")
    public String list(Model model) {
        List<Majors> majors= majorService.findMajor();
        model.addAttribute("majors", majors);
        return "majors/majorList";
    }

}
