package ua.edu.nlu.oldlib.listener;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by pc8 on 18.03.16.
 */
@Component
public class SessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session created : " + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session destroyed : " + httpSessionEvent.getSession().getId());
    }
}
