package my.library.controller;

import my.library.dao.GenericDAO;
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

@Controller
public class GenreController extends AbstractController {

    private static final String GENRE = "Genre";
    private GenericDAO<Genre> genreDao;

    @Transactional
    @GetMapping("/library/genres")
    public String getGenres(Model model) {
        try {
            List<Genre> genres = genreDao.findAll();
            model.addAttribute("genres", genres);
            return "genres";
        } catch (HibernateException e) {
            addErrorToModel(model, e, GENRE);
            return "error";
        }
    }

    @Transactional
    @GetMapping("/library/genres/genre")
    public String showGenre(@RequestParam(name = "id") Long id, Model model) {
        try {
            Genre genre = genreDao.findById(id);
            model.addAttribute("genre", genre);
            return "genre";
        } catch (HibernateException e) {
            addErrorToModel(model, e, GENRE);
            return "error";
        }

    }

    @Transactional
    @GetMapping("/library/genres/getCrudForm")
    public String getCrudForm(@RequestParam("opr") String operation, Model model) {
        try {
            Genre genre = new Genre();
            model.addAttribute("genre", genre);
            model.addAttribute("operation", operation);
            return "genresCrudForm";
        } catch (HibernateException e) {
            addErrorToModel(model, e, GENRE);
            return "error";
        }
    }

    @Transactional
    @PostMapping("/library/genres/add")
    public String addGenre(@Valid @ModelAttribute Genre genre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "genresCrudForm";
        }
        try {
            genreDao.create(genre);
            model.addAttribute("genre", new Genre());
            model.addAttribute("operation", "add");
            model.addAttribute("msg", "Congratulations. Genre added");
            return "genresCrudForm";
        } catch (HibernateException e) {
            model.addAttribute("msg", "Ups. There was some errors");
            addErrorToModel(model, e, GENRE);
            return "genresCrudForm";
        }
    }

    @Transactional
    @PostMapping("/library/genres/delete")
    public String deleteAuthor(@Valid @ModelAttribute("genre") Genre genre,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "authorDeleteError";
        }
        try {
            Genre genreToDelete = genreDao.findById(genre.getGenreId());
            genreDao.delete(genreToDelete);
            model.addAttribute("author", new Genre());
            return "authorDeleteSuccess";
        } catch (HibernateException | IllegalArgumentException e) {
            addErrorToModel(model, e, GENRE);
            return "authorDeleteError";
        }
    }

    @Autowired
    public void setGenreDao(GenericDAO<Genre> genreDao) {
        this.genreDao = genreDao;
    }
}
