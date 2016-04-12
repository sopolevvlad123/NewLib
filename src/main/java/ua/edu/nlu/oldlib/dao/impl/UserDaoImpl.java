package ua.edu.nlu.oldlib.dao.impl;

import ua.edu.nlu.oldlib.dao.UserDao;
import com.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc9 on 28.03.16.
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }


    public User getUser(Integer id) {

        Session session = this.sessionFactory.openSession();
        User user = (User)session.get(User.class, id);
        session.close();
        return user;
    }

    public User getUserWithJoins(Integer id){
        Session session = sessionFactory.openSession();
        User user = (User)session.get(User.class, id);
        Hibernate.initialize(user.getJoinUserBooks());
        return user;
    }

    public List<User> getAllUsers() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = (List<User>) session.createCriteria(User.class).list();
        return userList;
    }

    public void saveUser (User user){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

}
