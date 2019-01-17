package my.library.dao;

import my.library.model.Book;

public class BookDao extends AbstractDao<Book> implements GenericDao<Book> {

    public BookDao() {
        setClazz(Book.class);
    }

}
