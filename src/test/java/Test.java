import my.library.dao.BookDao;
import my.library.model.Author;
import my.library.model.Book;
import my.library.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    @org.junit.Test
    public void test() {

        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        session.beginTransaction();

        Author author = new Author();
        author.setName("Sergey");
        author.setSecond_Name("Tomashchuk");
        author.setThird_Name("Evgenievich");
        author.setBirth_Year(1986);
        author.setBiography("biogr1");

        session.save(author);

        Author author2 = new Author();
        author2.setName("Sergey2");
        author2.setSecond_Name("Tomashchuk2");
        author2.setThird_Name("Evgenievich2");
        author2.setBirth_Year(19862);
        author2.setBiography("biogr2");

        session.save(author2);

        Genre genre = new Genre();
        genre.setName("Blockbuster");

        Book book = new Book();
        book.setName("Potter");
        book.setPub_Year(2000);
        book.setGenre(genre);
        book.addAuthor(author);
        book.addAuthor(author2);

        session.save(book);
//        session.save(author);
//        session.save(author2);

//        Book book2 = new Book();
//        book2.setName("Potter");
//        book2.setPub_Year(2000);
//        book2.setGenre(genre);


        session.getTransaction().commit();
    }
}
