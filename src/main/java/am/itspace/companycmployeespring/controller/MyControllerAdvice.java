package am.itspace.companycmployeespring.controller;
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
//    //ստանում ենք էս պահի url-ը, պիտի սպլիտ անենք
//    @ModelAttribute(name ="currentUrl" )
//    public String currentUrl(HttpServletRequest request){
//        return request.getRequestURI();
//
//    }
}
