package ua.edu.nlu.oldlib.service;

import org.springframework.stereotype.Service;
import ua.edu.nlu.oldlib.dao.BookDao;
import ua.edu.nlu.oldlib.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pc9 on 04.04.16.
 */
@Service
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
