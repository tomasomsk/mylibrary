package my.library.controller;

import my.library.dao.GenericDao;
import my.library.dao.GenreDao;
import my.library.model.Book;
import my.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    private GenericDao<Book> bookDao;
    private GenericDao<Genre> genreDao;

    @GetMapping("/library/books")
    public String showBooks(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/library/books/book")
    public String showBook(@RequestParam(name="id") Long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/library/books/getaddform")
    public String getAddBookPage(Model model) {
        Book book= new Book();
        model.addAttribute("book", book);
        model.addAttribute("genres", genreDao.findAll().stream().map(Genre::getName).collect(Collectors.toList()));
        return "bookAdd";
    }

    @PostMapping("/library/books/add")
    public String addBook(@Valid @ModelAttribute("book") Book book,
                            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "bookAddError";
        }
        Genre genre = ((GenreDao) genreDao).findByName(book.getGenre().getName());
        book.setGenre(genre);
        bookDao.create(book);
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genreDao.findAll().stream().map(Genre::getName).collect(Collectors.toList()));
        return "bookAddSuccess";
    }

    @Autowired
    public void setBookDao(GenericDao<Book> bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setGenreDao(GenericDao<Genre> genreDao) {
        this.genreDao = genreDao;
    }
}
