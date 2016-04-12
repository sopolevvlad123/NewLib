package com.dao;

import com.entity.Book;
import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc9 on 31.03.16.
 */
@Repository
public interface UserBookJoinDao {
    public void setBook(User user,Book book);
    public void setBookList(User user, List<Book> bookList);
    public void removeBook(User user,Book book);
    public void removeBookList(User user, List<Book> bookList);

}
