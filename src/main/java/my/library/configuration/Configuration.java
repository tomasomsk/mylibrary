package my.library.configuration;

import my.library.dao.AuthorDAO;
import my.library.dao.BookDAO;
import my.library.dao.GenericDAO;
import my.library.dao.GenreDAO;
import my.library.model.Author;
import my.library.model.Book;
import my.library.model.Genre;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    @Scope()
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    @Scope()
    public GenericDAO<Author> authorDao() {
        return new AuthorDAO();
    }

    @Bean
    @Scope()
    public GenericDAO<Book> bookDao() {
        return new BookDAO();
    }

    @Bean
    @Scope()
    public GenericDAO<Genre> genreDao() {
        return new GenreDAO();
    }
}
