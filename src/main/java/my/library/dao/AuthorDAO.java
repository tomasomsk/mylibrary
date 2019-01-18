package my.library.dao;

import my.library.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class  AuthorDAO extends AbstractDAO<Author> implements GenericDAO<Author> {

    public AuthorDAO() {
        setClazz(Author.class);
    }
}
