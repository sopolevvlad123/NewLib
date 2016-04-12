package ua.edu.nlu.oldlib.dao.impl;

import ua.edu.nlu.oldlib.dao.JoinUserBookDao;
import ua.edu.nlu.oldlib.dao.RangeDao;
import com.entity.JoinUserBook;
import com.entity.Range;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pc9 on 05.04.16.
 */
public class RangeDaoImpl implements RangeDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private JoinUserBookDao joinUserBookDao;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public JoinUserBookDao getJoinUserBookDao() {
        return joinUserBookDao;
    }

    public void setJoinUserBookDao(JoinUserBookDao joinUserBookDao) {
        this.joinUserBookDao = joinUserBookDao;
    }

    public void setRange(JoinUserBook join, Integer start, Integer finish) {
       Session session = this.sessionFactory.openSession();
       session.beginTransaction();
       Range range = new Range(start, finish);
       range.setJoinUserBook(join);
       session.save(range);
       session.getTransaction().commit();
       session.close();
    }

    public List<Range> getRanges(JoinUserBook join) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Range.class);
        List<Range> rangeList =  criteria.add(Restrictions.eq("tmp_simple.join_id", join.getTmpId())).list();
        session.getTransaction().commit();
        session.close();
        return rangeList;
    }

    public void deleteRange(JoinUserBook join, Range range) {

    }

    public void deleteAllRanges(JoinUserBook join) {

    }
}
