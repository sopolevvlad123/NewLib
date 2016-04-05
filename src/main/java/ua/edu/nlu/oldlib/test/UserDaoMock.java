package ua.edu.nlu.oldlib.test;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc8 on 22.03.16.
 */
@Component
public class UserDaoMock {

    private Map<String, UserMock> storage = new HashMap<>();

    public UserDaoMock(){

       // storage.put( "vasya" ,new UserMock("vasya", "81DC9BDB52D04DC20036DBD8313ED055", "ROLE_USER"));
        storage.put( "vasya" ,new UserMock("vasya", new Md5PasswordEncoder().encodePassword("1234", null), "ROLE_USER"));
        storage.put("admin", new UserMock("admin",new Md5PasswordEncoder().encodePassword("1111", null), "ROLE_ADMIN"));
    }

    public UserMock getUser(String email){
        return storage.get(email);
    }



}
