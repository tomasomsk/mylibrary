package my.library.dao;

import my.library.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookDAO extends AbstractDAO<Book> implements GenericDAO<Book> {

    public BookDAO() {
        setClazz(Book.class);
    }

}
