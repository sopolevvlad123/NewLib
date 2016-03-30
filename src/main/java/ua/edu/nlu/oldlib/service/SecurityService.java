package ua.edu.nlu.oldlib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.edu.nlu.oldlib.test.UserDaoMock;
import ua.edu.nlu.oldlib.test.UserMock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc8 on 22.03.16.
 */

public class SecurityService implements UserDetailsService {


    private UserDaoMock userDaoMock;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        System.out.println("!!!! " + userDaoMock.getUser(name).getRole() + " !!!!!!!!!!!");
        return buildUserForAuthentication(userDaoMock.getUser(name));
    }

     private User buildUserForAuthentication(UserMock userMock){

         List<GrantedAuthority> authorities = new ArrayList<>();
         authorities.add(new SimpleGrantedAuthority(userMock.getRole()));

         return new User(userMock.getName(), userMock.getPassword(), true, true,true,true,authorities);
     }

    public UserDaoMock getUserDaoMock() {
        return userDaoMock;
    }

    public void setUserDaoMock(UserDaoMock userDaoMock) {
        this.userDaoMock = userDaoMock;
    }
}
