package am.itspace.companycmployeespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

    @GetMapping("/admin")
    public String adminHome(){
        return "admin";
    }

}
