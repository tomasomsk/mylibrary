package my.library.controller;

import my.library.dao.GenericDAO;
import my.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/library/genres")
public class GenreController extends AbstractController {

    private static final String GENRE = "Genre";
    public static final String OPERATION = "operation";
    private GenericDAO<Genre> genreDao;

    @Transactional
    @GetMapping("")
    public String getGenres(@RequestParam(name = "opr", required = false) String operation, Model model) {
        try {
            if (operation != null) {
                model.addAttribute(OPERATION, operation);
            }
            List<Genre> genres = genreDao.findAll();
            model.addAttribute("genres", genres);
            return "genres";
        } catch (Exception e) {
            addErrorToModel(model, e, GENRE);
            return "error";
        }
    }

    @Transactional
    @GetMapping("genre")
    public String showGenre(@RequestParam(name = "id") Long id, Model model) {
        try {
            Genre genre = genreDao.findById(id);
            model.addAttribute("genre", genre);
            return "genre";
        } catch (Exception e) {
            addErrorToModel(model, e, GENRE);
            return "error";
        }

    }

    @Transactional
    @GetMapping("getCrudForm")
    public String getCrudForm(@RequestParam("opr") String operation, Model model) {
        try {
            Genre genre = new Genre();
            model.addAttribute("genre", genre);
            model.addAttribute(OPERATION, operation);
            return "genresCrudForm";
        } catch (Exception e) {
            addErrorToModel(model, e, GENRE);
            return "error";
        }
    }

    @Transactional
    @PostMapping("add")
    public String addGenre(@Valid @ModelAttribute Genre genre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "genresCrudForm";
        }
        model.addAttribute(OPERATION, "add");
        try {
            genreDao.create(genre);
            model.addAttribute("genre", new Genre());
            model.addAttribute("msg", "Congratulations. Genre added");
            return "genresCrudForm";
        } catch (Exception e) {
            model.addAttribute("msg", "Ups. There was some errors");
            addErrorToModel(model, e, GENRE);
            return "genresCrudForm";
        }
    }

    @Transactional
    @PostMapping("delete")
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
            return "genresCrudForm";
        } catch (Exception e) {
            addErrorToModel(model, e, GENRE);
            return "genresCrudForm";
        }
    }

    @Autowired
    public void setGenreDao(GenericDAO<Genre> genreDao) {
        this.genreDao = genreDao;
    }
}
