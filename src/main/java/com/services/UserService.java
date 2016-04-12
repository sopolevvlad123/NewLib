package com.services;

import com.dao.UserDao;
import com.entity.JoinUserBook;
import com.entity.Range;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc9 on 04.04.16.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JoinService joinService;
    @Autowired
    private BookService bookService;
    @Autowired
    private RangeService rangeService;

    public User getUser(Integer userId){
        return  userDao.getUser(userId);
    }

    public List<User> getAllUser(){
        return userDao.getAllUsers();
    }

    public void creaeUser(User user){
        userDao.saveUser(user);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void deleteUser(User user){
        userDao.updateUser(user);
    }

    public void addBook(Integer userId,Integer bookId){
        joinService.createJoin(userDao.getUser(userId), bookService.getBook(bookId));
    }

    public void deleteBook(Integer userId,Integer bookId){
        joinService.deleteJoin(userId, bookId);
    }

    public void addRange(Integer userId,Integer bookId,Integer start,Integer finish){
        JoinUserBook join = joinService.getJoin(userId, bookId);
        rangeService.setRange(join, start, finish);
    }
    //
    public void deleteRange(Integer userId,Integer bookId,Integer start,Integer finish){
        JoinUserBook join = joinService.getJoin(userId, bookId);
        rangeService.deleteRange(join, new Range(start, finish));
    }

}


