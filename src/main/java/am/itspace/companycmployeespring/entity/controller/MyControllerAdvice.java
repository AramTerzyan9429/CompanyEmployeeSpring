package am.itspace.companycmployeespring.entity.controller;

import am.itspace.companycmployeespring.entity.User;
import am.itspace.companycmployeespring.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyControllerAdvice {

    @ModelAttribute
    public User currentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {

            return currentUser.getUser();
        }
        return null;
    }

}
