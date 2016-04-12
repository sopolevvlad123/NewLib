package com.services;

import com.dao.BookDao;
import com.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pc9 on 04.04.16.
 */
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book getBook(Integer bookId){
        return bookDao.getBook(bookId);
    }

    public List<Book> getAllBooks(){
        return bookDao.getAllBook();
    }

}
