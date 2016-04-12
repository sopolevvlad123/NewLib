package ua.edu.nlu.oldlib.dao.impl;

import ua.edu.nlu.oldlib.dao.JoinUserBookDao;
import com.entity.JoinUserBook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pc9 on 01.04.16.
 */
@Repository
public class JoinUserBookDaoImpl implements JoinUserBookDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setJoin(JoinUserBook join) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        //JoinUserBook join = new JoinUserBook(user, book);
        session.save(join);
        session.getTransaction().commit();
        session.close();
    }

    @Transactional
    public void updateJoin(JoinUserBook join) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(join);
        session.getTransaction().commit();
        session.close();
    }

    public JoinUserBook getJoin(Integer userId, Integer bookId) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JoinUserBook.class);
        JoinUserBook join = (JoinUserBook) criteria.add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("book.bookId", bookId)).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return join;
    }

    @Transactional
    public void deleteJoin(Integer userId, Integer bookId) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(getJoin(userId,bookId));
        session.getTransaction().commit();
        session.close();
    }

}
