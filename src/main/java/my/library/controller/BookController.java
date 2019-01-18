package my.library.controller;

import my.library.dao.GenericDAO;
import my.library.model.Author;
import my.library.model.Book;
import my.library.model.Genre;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController extends AbstractController {

    private static final String BOOK = "Book";
    private GenericDAO<Book> bookDao;
    private GenericDAO<Genre> genreDao;

    @Transactional
    @GetMapping("/library/books")
    public String showBooks(Model model) {
        try {
            List<Book> books = bookDao.findAll();
            model.addAttribute("books", books);
            return "books";
        } catch (HibernateException e) {
            addErrorToModel(model, e, BOOK);
            return "error";
        }
    }

    @Transactional
    @GetMapping("/library/books/book")
    public String showBook(@RequestParam(name = "id") Long id, Model model) {
        try {
            Book book = bookDao.findById(id);
            model.addAttribute("book", book);
            return "book";
        } catch (HibernateException e) {
            addErrorToModel(model, e, BOOK);
            return "error";
        }
    }

    @Transactional
    @GetMapping("/library/books/getaddform")
    public String getAddBookPage(Model model) {
        try {
            Book book = new Book();
            model.addAttribute("book", book);
            model.addAttribute("genres", genreDao.findAll().stream().map(Genre::getName).collect(Collectors.toList()));
            return "bookAdd";
        } catch (HibernateException e) {
            addErrorToModel(model, e, BOOK);
            return "error";
        }
    }

    @Transactional
    @PostMapping("/library/books/add")
    public String addBook(@Valid @ModelAttribute("book") Book book,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "bookAddError";
        }
        try {
            Genre genre = genreDao.findByName(book.getGenre().getName());
            book.setGenre(genre);
            bookDao.create(book);
            model.addAttribute("book", new Book());
            model.addAttribute("genres", genreDao.findAll().stream().map(Genre::getName).collect(Collectors.toList()));
            return "bookAddSuccess";
        } catch (HibernateException e) {
            addErrorToModel(model, e, BOOK);
            return "bookAddError";
        }
    }

    @Transactional
    @GetMapping("/library/books/getdeleteform")
    public String getDeleteBookPage(Model model) {
        try {
            Book book = new Book();
            model.addAttribute("book", book);
            return "bookDelete";
        } catch (HibernateException e) {
            addErrorToModel(model, e, BOOK);
            return "error";
        }
    }

    @Transactional
    @PostMapping("/library/books/delete")
    public String deleteBook(@Valid @ModelAttribute("book") Book book,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "bookDeleteError";
        }
        try {
            Book bookToDelete = bookDao.findById(book.getBookId());
            bookDao.delete(bookToDelete);
            model.addAttribute("book", new Book());
            return "bookDeleteSuccess";
        } catch (HibernateException | IllegalArgumentException e) {
            addErrorToModel(model, e, BOOK);
            return "bookDeleteError";
        }
    }

    @Autowired
    public void setBookDao(GenericDAO<Book> bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setGenreDao(GenericDAO<Genre> genreDao) {
        this.genreDao = genreDao;
    }
}
