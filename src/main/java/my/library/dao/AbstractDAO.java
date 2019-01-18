package my.library.dao;

import my.library.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public abstract class AbstractDAO<T> {

    private Class<T> clazz;

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

    void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public T findById(Long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public void create(T entity)  {
        Session session = getCurrentSession();
//        session.beginTransaction();
        session.persist(entity);
//        session.flush();
//        session.getTransaction().commit();
    }

    public T update(T entity) {
        Session session = getCurrentSession();
//        session.beginTransaction();
        T result = (T) session.merge(entity);
//        session.flush();
//        session.getTransaction().commit();
        return result;
    }

    public void delete(T entity) throws DaoException {
        Session session = getCurrentSession();
//        session.beginTransaction();
        session.delete(entity);
//        session.flush();
//        session.getTransaction().commit();
    }

    public final Session getCurrentSession() {
        Session session = sessionFactory.getCurrentSession();
//        session.setFlushMode(FlushMode.MANUAL);
        return session;
    }

    public T findByName(String name) {
//        getCurrentSession().beginTransaction();
        Query query = getCurrentSession().createQuery("from " + clazz.getName() + " where name=:name");
        query.setParameter("name", name);
        return (T) query.uniqueResult();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
