package my.library.controller;

import my.library.dao.GenericDAO;
import my.library.model.Author;
import my.library.model.Book;
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

@Controller
public class AuthorController extends AbstractController {

    private static final String AUTHOR = "Author";
    private GenericDAO<Author> authorDao;
    private GenericDAO<Book> bookDao;

    @Transactional
    @GetMapping("/library/authors")
    public String showAuthors(Model model) {
        try {
            List<Author> authors = authorDao.findAll();
            model.addAttribute("authors", authors);
            return "authors";
        } catch (HibernateException e) {
            addErrorToModel(model, e, AUTHOR);
            return "error";
        }
    }

    @Transactional
    @GetMapping("/library/authors/author")
    public String showAuthor(@RequestParam(name = "id") Long id, Model model) {
        try {
            Author author = authorDao.findById(id);
            List<Book> books = author.getBooks();
            model.addAttribute("author", author);
            model.addAttribute("books", books);
            return "author";
        } catch (HibernateException e) {
            addErrorToModel(model, e, AUTHOR);
            return "error";
        }
    }

    @Transactional
    @GetMapping("/library/authors/getaddform")
    public String getAddAuthorPage(Model model) {
        try {
            Author author = new Author();
            model.addAttribute("author", author);
            return "authorAdd";
        } catch (HibernateException e) {
            addErrorToModel(model, e, AUTHOR);
            return "error";
        }
    }

    @Transactional
    @PostMapping("/library/authors/add")
    public String addAuthor(@Valid @ModelAttribute("author") Author author,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "authorAddError";
        }
        try {
            authorDao.create(author);
            model.addAttribute("author", new Author());
            return "authorAddSuccess";
        } catch (HibernateException e) {
            addErrorToModel(model, e, AUTHOR);
            return "authorAddError";
        }
    }

    @Transactional
    @GetMapping("/library/authors/getdeleteform")
    public String getDeleteAuthorPage(Model model) {
        try {
            Author author = new Author();
            model.addAttribute("author", author);
            return "authorDelete";
        } catch (HibernateException e) {
            addErrorToModel(model, e, AUTHOR);
            return "error";
        }
    }

    @Transactional
    @PostMapping("/library/authors/delete")
    public String deleteAuthor(@Valid @ModelAttribute("author") Author author,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "authorDeleteError";
        }
        try {
            Author authorToDelete = authorDao.findById(author.getAuthorId());
            authorDao.delete(authorToDelete);
            model.addAttribute("author", new Author());
            return "authorDeleteSuccess";
        } catch (HibernateException | IllegalArgumentException e) {
            addErrorToModel(model, e, AUTHOR);
            return "authorDeleteError";
        }
    }

    @Transactional
    @GetMapping("/library/author/getAuthorAddBookForm")
    public String getAddBookToAuthorPage(@RequestParam(name = "authorid") Long id, Model model) {
        try {
            List<Book> books = bookDao.findAll();
            model.addAttribute("books", books);
            model.addAttribute("book", new Book());
            Author author = authorDao.findById(id);
            model.addAttribute("author", author);
            return "authorAddBook";
        } catch (HibernateException e) {
            addErrorToModel(model, e, AUTHOR);
            return "error";
        }
    }

    @Transactional
    @PostMapping("/library/author/addBook")
    public String addBookToAuthor(@Valid @RequestParam("author_id") long author_id,
                                  @Valid @RequestParam("book_id") long book_id,
                                  Model model) {
        try {
            Book bookToAdd = bookDao.findById(book_id);
            Author author = authorDao.findById(author_id);
            author.addBook(bookToAdd);
            authorDao.update(author);
            return "authorAddBookSuccess";
        } catch (HibernateException e) {
            addErrorToModel(model, e, AUTHOR);
            return "authorAddBookError";
        }
    }

    @Autowired
    public void setAuthorDao(GenericDAO<Author> authorDao) {
        this.authorDao = authorDao;
    }

    @Autowired
    public void setBookDao(GenericDAO<Book> bookDao) {
        this.bookDao = bookDao;
    }
}
