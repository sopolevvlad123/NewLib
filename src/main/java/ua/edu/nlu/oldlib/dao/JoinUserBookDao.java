package ua.edu.nlu.oldlib.dao;

import com.entity.JoinUserBook;
import org.springframework.stereotype.Repository;

/**
 * Created by pc9 on 01.04.16.
 */
@Repository
public interface JoinUserBookDao {

    void setJoin(JoinUserBook join);

    void updateJoin(JoinUserBook join);

    void deleteJoin(Integer userId, Integer bookId);

    JoinUserBook getJoin(Integer userId, Integer bookId);

}
