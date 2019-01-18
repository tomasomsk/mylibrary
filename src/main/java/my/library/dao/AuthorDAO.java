package my.library.dao;

import my.library.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAO extends AbstractDAO<Author> implements GenericDAO<Author> {

    public AuthorDAO() {
        setClazz(Author.class);
    }
}
