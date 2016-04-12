package ua.edu.nlu.oldlib.dao;

import com.entity.Book;

import java.util.List;

/**
 * Created by pc9 on 31.03.16.
 */
public interface BookDao {
    public Book getBook(Integer bookId);
    public Book getBookWithJoins(Integer bookId);

    public List<Book> getAllBook();

}
