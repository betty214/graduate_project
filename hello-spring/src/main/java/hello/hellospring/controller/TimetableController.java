package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class TimetableController {
    private final MemberService TimetableService;
    @Autowired
    public TimetableController(MemberService timetableService) {
        this.TimetableService = timetableService;
    }

    @GetMapping(value = "/timetable")
    public String list() {
        return "timetable/timetableList.html";
    }
    @GetMapping(value = "/majors")
    public String li() {
        return "timetable/majorList.html";
    }
}
