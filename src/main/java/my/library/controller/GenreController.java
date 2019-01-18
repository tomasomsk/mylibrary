package my.library.controller;

import my.library.dao.GenericDAO;
import my.library.model.Genre;
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
public class GenreController extends AbstractController {

    public static final String GENRE = "Genre";
    private GenericDAO<Genre> genreDao;

    @GetMapping("/library/genres")
    public String getGenres(Model model) {
        List<Genre> genres = genreDao.findAll();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @GetMapping("/library/genres/genre")
    public String showGenre(@RequestParam(name="id") Long id, Model model) {
        Genre genre = genreDao.findById(id);
        model.addAttribute("genre", genre);
        return "genre";
    }

    @GetMapping("/library/genres/getCrudForm")
    public String getCrudForm(@RequestParam("opr") String operation, Model model) {
        try {
            Genre genre = new Genre();
            model.addAttribute("genre", genre);
            model.addAttribute("operation", operation);
            return "genresCrudForm";
        } catch (HibernateException e) {
            rollbackAndAddErrorToModel(model, e, GENRE, genreDao);
            return "error";
        }
    }

    @PostMapping("/library/genres/add")
    public String addGenre(@Valid @ModelAttribute Genre genre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "genresCrudForm";
        }
        try {
            genreDao.create(genre);
            model.addAttribute("genre", new Genre());
            model.addAttribute("errors", "no");
            model.addAttribute("operation", "add");
            return "genresCrudForm";
        } catch (HibernateException e) {
            rollbackAndAddErrorToModel(model, e, GENRE, genreDao);
            return "genresCrudForm";
        }
    }

    @Autowired
    public void setGenreDao(GenericDAO<Genre> genreDao) {
        this.genreDao = genreDao;
    }
}
