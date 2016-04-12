package com.dao;

import com.entity.JoinUserBook;
import com.entity.Range;

import java.util.List;

/**
 * Created by pc9 on 05.04.16.
 */
public interface RangeDao {
    public void setRange(JoinUserBook join, Integer start, Integer finish);
    public List<Range> getRanges(JoinUserBook join);
    public void deleteRange(JoinUserBook join, Range range);
    public void deleteAllRanges(JoinUserBook join);

}
