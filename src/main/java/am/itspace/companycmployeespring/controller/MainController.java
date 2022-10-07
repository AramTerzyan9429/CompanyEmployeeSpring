package am.itspace.companycmployeespring.controller;
import am.itspace.companycmployeespring.entity.User;
import am.itspace.companycmployeespring.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static am.itspace.companycmployeespring.entity.Role.ADMIN;
import static am.itspace.companycmployeespring.entity.Role.USER;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }


    @GetMapping("/accessDenid")
    public String accessDenied(){
        return "accessDenied";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal CurrentUser currentUser){
        if (currentUser !=null){
            User user = currentUser.getUser();
            if (user.getRole().equals(ADMIN)){

                return  "redirect:/admin";
            }else if (user.getRole().equals(USER)){
                return "redirect:/user";
            }
        }
        return "redirect:/";

    }

    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "error",required = false)String error, ModelMap modelMap){
        if (error!=null&& error.equals("true")) {
            modelMap.addAttribute("error","true");
        }
        return "loginPage";
    }
}
