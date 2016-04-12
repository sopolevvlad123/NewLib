package ua.edu.nlu.oldlib.service;

import ua.edu.nlu.oldlib.dao.BookDao;
import ua.edu.nlu.oldlib.dao.JoinUserBookDao;
import ua.edu.nlu.oldlib.dao.UserDao;
import ua.edu.nlu.oldlib.entity.Book;
import ua.edu.nlu.oldlib.entity.JoinUserBook;
import ua.edu.nlu.oldlib.entity.Range;
import ua.edu.nlu.oldlib.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by pc9 on 04.04.16.
 */

public class JoinService {

    @Autowired
    private JoinUserBookDao joinUserBookDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    public void createJoin(User user, Book book) {
        JoinUserBook join = new JoinUserBook(user, book);
        joinUserBookDao.setJoin(join);
    }

    public void createJoin(User user, Book book, Integer bookmark) {
        JoinUserBook join = new JoinUserBook(user, book, bookmark);
        System.out.println("user--" + user + "book---" + book + "mark---" + bookmark);
        System.out.println("join ---" + join);
        System.out.println("dao---"+joinUserBookDao);
        System.out.println("dao2---"+bookDao);
        joinUserBookDao.setJoin(join);
    }

    public void createJoin(User user, Book book, Integer bookmark, Range range) {
        JoinUserBook join = new JoinUserBook(user, book, bookmark, range);
        joinUserBookDao.setJoin(join);
    }

    public void createJoin(User user, Book book, Integer bookmark, Set<Range> ranges) {
        JoinUserBook join = new JoinUserBook(user, book, bookmark, ranges);
        joinUserBookDao.setJoin(join);
    }

    public JoinUserBook getJoin(Integer userId, Integer bookId){
       return joinUserBookDao.getJoin(userId, bookId);
    }
    public void deleteJoin(Integer userId, Integer bookId) {
    joinUserBookDao.deleteJoin(userId, bookId);
    }

    public void updateJoin(JoinUserBook join) {
        joinUserBookDao.updateJoin(join);
    }

    public boolean isPageAlloved(Integer userId, Integer bookId, Integer page){

        JoinUserBook join = joinUserBookDao.getJoin(userId, bookId);
        Set<Integer> pageSet= join.getPageSet(20);
        Iterator<Integer> iterator = pageSet.iterator();

        while (iterator.hasNext()){
            if (iterator.next().equals(page)){
                return true;
            }
        }
        return false;
    }

}
