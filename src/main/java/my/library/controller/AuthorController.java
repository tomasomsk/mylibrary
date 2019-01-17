package my.library.controller;

import my.library.dao.GenericDao;
import my.library.model.Author;
import my.library.model.Book;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    private GenericDao<Author> authorDao;

    @GetMapping("/library/authors")
    public String showAuthors(Model model) {
        try {
            List<Author> authors = authorDao.findAll();
            model.addAttribute("authors", authors);
            return "authors";
        } catch (HibernateException e) {
            rollbackAndAddErrorToModel(model, e, "Author", authorDao);
            return "error";
        }
    }

    @GetMapping("/library/authors/author")
    public String showAuthor(@RequestParam(name = "id") Long id, Model model) {
        Author author = authorDao.findById(id);
        List<Book> books = author.getBooks();
        model.addAttribute("author", author);
        model.addAttribute("books", books);
        return "author";
    }

    @GetMapping("/library/authors/getaddform")
    public String getAddAuthorPage(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authorAdd";
    }

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
            rollbackAndAddErrorToModel(model, e, "Author", authorDao);
            return "authorAddError";
        }
    }

    @GetMapping("/library/authors/getdeleteform")
    public String getDeleteAuthorPage(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authorDelete";
    }

    @PostMapping("/library/authors/delete")
    public String deleteAuthor(@Valid @ModelAttribute("author") Author author,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "authorDeleteError";
        }
        try {
            Author authorToDelete = authorDao.findById(author.getId());
            authorDao.delete(authorToDelete);
            model.addAttribute("author", new Author());
            return "authorDeleteSuccess";
        } catch (HibernateException | IllegalArgumentException e) {
            rollbackAndAddErrorToModel(model, e, "Author", authorDao);
            return "authorDeleteError";
        }
    }

    @Autowired
    public void setAuthorDao(GenericDao<Author> authorDao) {
        this.authorDao = authorDao;
    }
}
