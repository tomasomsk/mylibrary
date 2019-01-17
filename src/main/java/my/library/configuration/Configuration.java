package my.library.configuration;

import my.library.dao.AuthorDao;
import my.library.dao.BookDao;
import my.library.dao.GenericDao;
import my.library.dao.GenreDao;
import my.library.model.Author;
import my.library.model.Book;
import my.library.model.Genre;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    @Scope()
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    @Scope()
    public GenericDao<Author> authorDao() {
        return new AuthorDao();
    }

    @Bean
    @Scope()
    public GenericDao<Book> bookDao() {
        return new BookDao();
    }

    @Bean
    @Scope()
    public GenericDao<Genre> genreDao() {
        return new GenreDao();
    }
}
