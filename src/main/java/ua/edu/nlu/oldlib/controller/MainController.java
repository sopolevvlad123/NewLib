package ua.edu.nlu.oldlib.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.edu.nlu.oldlib.service.FtpService;

import javax.servlet.http.HttpSession;

/**
 * Created by pc8 on 10.03.16.
 */
@Controller
public class MainController {

    @Autowired
    FtpService ftpService;

    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        System.out.println("Hellooo");
         //    ftpTest.download();


        return "app/index.html";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable("id") Integer id  ){
      //  System.out.println("Hellooo");
        ftpService.download(String.valueOf(id));
        System.out.println(id);

        return "app/index.html";
    }

}
