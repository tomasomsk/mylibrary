package my.library.dao;

import my.library.model.Genre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GenreDAO extends AbstractDAO<Genre> implements GenericDAO<Genre> {

    public GenreDAO() {
        setClazz(Genre.class);
    }

}
