package ua.edu.nlu.oldlib.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nlu.oldlib.service.FileService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pc8 on 05.04.16.
 */
@Controller
public class ImagesController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/img/{bookId}", method = RequestMethod.GET)
    public void getImage(HttpServletResponse response, @PathVariable("bookId") int bookId,
                         @RequestParam("pageId") String pageId) throws IOException{

        System.out.println("IMAGE CONTROLLER...........");

       Object object =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user;
        if (object instanceof User){
            user = (User) object;
            System.out.println("NAME OF PRINCIPAL IN IMAGE CONTROLLER" +
                    " = " + user.getUsername());
        }


        System.out.println( "IMAGE CONTROLLER " + object.toString());
      //  System.out.println( "IMAGE CONTROLLER SESSION " + httpSession.getId());

        try(InputStream inputStream = new FileInputStream(fileService.getPage(bookId, pageId))){
            IOUtils.copy(inputStream, response.getOutputStream());
        }

    }


}
