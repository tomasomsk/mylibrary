package my.library.dao;

import my.library.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO extends AbstractDAO<Book> implements GenericDAO<Book> {

    public BookDAO() {
        setClazz(Book.class);
    }

}
