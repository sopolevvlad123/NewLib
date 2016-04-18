package ua.edu.nlu.oldlib.service;

import org.springframework.stereotype.Service;
import ua.edu.nlu.oldlib.dao.RangeDao;
import ua.edu.nlu.oldlib.entity.JoinUserBook;
import ua.edu.nlu.oldlib.entity.Range;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pc9 on 07.04.16.
 */
@Service
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
