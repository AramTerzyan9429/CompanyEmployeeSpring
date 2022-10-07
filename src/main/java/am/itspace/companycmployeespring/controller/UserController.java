package am.itspace.companycmployeespring.controller;

import am.itspace.companycmployeespring.dto.CreateUserDto;
import am.itspace.companycmployeespring.entity.User;
import am.itspace.companycmployeespring.mapper.UserMapper;
import am.itspace.companycmployeespring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping("/user")
    public String userPage(){
        return "user";
    }

    @GetMapping("/users")
    public String user(ModelMap modelMap) {
        List<User> users = userRepository.findAll();
        modelMap.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/users/add")
    public String addUser() {
        return "addUser";
    }



    @PostMapping("/users/add")
    public String add(@ModelAttribute CreateUserDto dto, ModelMap modelMap) {
        if (userRepository.existsByEmailIgnoreCase(dto.getEmail())) {
            modelMap.addAttribute("errorMassage", "Email already is user");
            return "addUser";
        }
        userRepository.save(userMapper.mapToEntity(dto));
        return "redirect:/user";
    }



    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
