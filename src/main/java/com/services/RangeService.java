package com.services;

import com.dao.RangeDao;
import com.entity.JoinUserBook;
import com.entity.Range;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pc9 on 07.04.16.
 */
public class RangeService {
    @Autowired
    private RangeDao rangeDao;


    public void setRange(JoinUserBook join, Integer start, Integer finish){
          rangeDao.setRange(join,start,finish);

    }

    public List<Range> getRanges(JoinUserBook join){
        return rangeDao.getRanges(join);
    }

    public void deleteRange(JoinUserBook join, Range range){
        rangeDao.deleteRange(join,range);
    }

    public void deleteAllRanges(JoinUserBook join){

    }

}