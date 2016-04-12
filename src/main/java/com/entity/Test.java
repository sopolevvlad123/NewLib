package com.entity;

import com.dao.BookDao;
import com.dao.JoinUserBookDao;
import com.dao.RangeDao;
import com.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by pc9 on 28.03.16.
 */
public class Test {
    @Autowired
    SessionFactory sessionFactory;

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            User user1 = new User("111","Vasyl","Dudow","No_Trans@mail.ru",false, 0 );
            User user2 = new User("23332","Stanylav","Gryzha","korgerges@mail.ru",false, 0 );
            User user3 = new User("333","Ibrahim","Dobrodomov","Almaz@mail.ru",false, 0 );


        UserDao userDAO = context.getBean(UserDao.class);
        BookDao bookDao = context.getBean(BookDao.class);
        JoinUserBookDao joinUserBookDao = context.getBean(JoinUserBookDao.class);
        RangeDao rangeDao = context.getBean(RangeDao.class);


        User user =userDAO.getUser(50);

        Book book = bookDao.getBook(2336);

        JoinUserBook join = user.getJoin(2462);
        System.out.println("JOIN ---- " + join);
        System.out.println("Ranges ----- "+ user.getJoin(2462).getPageSet(2));


/*
        JoinUserBook join = new JoinUserBook(user, book, 123456);

        System.out.println("join ---" + join);
        joinUserBookDao.setJoin(join);*/
        //joinService.createJoin(user, book, 123456);


    }




        /*joinUserBookDao.setJoin(user,book1);
        joinUserBookDao.setJoin(user, bookDao.getBook(2260));
        joinUserBookDao.setJoin(user, bookDao.getBook(2267));
        joinUserBookDao.setJoin(user, bookDao.getBook(2276));
        joinUserBookDao.setJoin(user, bookDao.getBook(2277));
        joinUserBookDao.setJoin(user, bookDao.getBook(2279));
        */

}
