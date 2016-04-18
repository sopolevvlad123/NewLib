package ua.edu.nlu.oldlib.dao;

import org.springframework.stereotype.Repository;
import ua.edu.nlu.oldlib.entity.Book;

import java.util.List;

/**
 * Created by pc9 on 31.03.16.
 */
@Repository
public interface BookDao {
    public Book getBook(Integer bookId);
    public Book getBookWithJoins(Integer bookId);

    public List<Book> getAllBook();

}
