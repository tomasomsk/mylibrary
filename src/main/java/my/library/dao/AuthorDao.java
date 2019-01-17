package my.library.dao;

import my.library.model.Author;

public class AuthorDao extends AbstractDao<Author> implements GenericDao<Author> {

    public AuthorDao() {
        setClazz(Author.class);
    }

}
