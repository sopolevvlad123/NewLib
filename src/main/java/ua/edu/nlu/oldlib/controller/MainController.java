package ua.edu.nlu.oldlib.controller;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nlu.oldlib.service.FileService;
import ua.edu.nlu.oldlib.service.FtpService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pc8 on 10.03.16.
 */
@Controller
public class MainController {

    @Autowired
    FtpService ftpService;

    @Autowired
    FileService fileService;

    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        System.out.println("Hellooo");
         //    ftpTest.download();


        return "app/index.html";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable("id") Integer id, HttpSession httpSession){

        System.out.println("SESSION IN CONTROLLER "  + httpSession.getId());

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("NAME OF PRINCIPAL" +
                " = " + user.getUsername() + "  " + httpSession.getId());
        httpSession.setAttribute("name", user.getUsername());
        ftpService.download(String.valueOf(id));
        System.out.println(id);

        return "app/index.html";
    }



}
