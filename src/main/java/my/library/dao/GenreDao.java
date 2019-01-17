package my.library.dao;

import my.library.model.Genre;
import org.hibernate.Query;

public class GenreDao extends AbstractDao<Genre> implements GenericDao<Genre> {

    public GenreDao() {
        setClazz(Genre.class);
    }

    public Genre findByName(String name) {
        getCurrentSession().beginTransaction();
        Query query = getCurrentSession().createQuery("from Genre where name=:name");
        query.setParameter("name", name);
        return (Genre) query.uniqueResult();
    }

}
