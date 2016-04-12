package com.dao.impl;

import com.dao.BookDao;
import com.entity.Book;
import com.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc9 on 31.03.16.
 */
@Repository
public class BookDaoIpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Book getBook(Integer bookId) {
        Session session = this.sessionFactory.openSession();
        Book book = (Book) session.get(Book.class,bookId);
        session.close();
        return book;
    }

    public Book getBookWithJoins(Integer bookId) {
        Session session = this.sessionFactory.openSession();
        Book book = (Book) session.get(Book.class,bookId);
        Hibernate.initialize(book.getJoinUserBooks());
        session.close();
        return book;
    }

    public List<Book> getAllBook() {
        Session session = this.sessionFactory.openSession();
        List<Book> bookList = (List<Book>) session.createCriteria(Book.class).list();
        session.close();
        return  bookList;
    }




}
