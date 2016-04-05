package ua.edu.nlu.oldlib.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by pc8 on 23.03.16.
 */
@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String helloAdmin(  ){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Hello admin " + user.getUsername() );
        return "Hello Admin!!! <a href ='/j_spring_security_logout'> logout  </a>";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
     public String login() {
        System.out.println("login");
        return "app/login.html";
    }

    @ResponseBody
    @RequestMapping(value = "/403" , method = {RequestMethod.GET, RequestMethod.POST} )
     public String errorPage()
    {
        return "Error!!!!!!!!!!!!!!!!!!!!";

    }

}
