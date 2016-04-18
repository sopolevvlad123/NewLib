package ua.edu.nlu.oldlib.dao;

import org.springframework.stereotype.Repository;
import ua.edu.nlu.oldlib.entity.JoinUserBook;
import ua.edu.nlu.oldlib.entity.Range;

import java.util.List;

/**
 * Created by pc9 on 05.04.16.
 */
@Repository
public interface RangeDao {
    public void setRange(JoinUserBook join, Integer start, Integer finish);
    public List<Range> getRanges(JoinUserBook join);
    public void deleteRange(JoinUserBook join, Range range);
    public void deleteAllRanges(JoinUserBook join);

}
