package com.dao;

import com.entity.Book;
import com.entity.JoinUserBook;
import com.entity.Range;
import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
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
