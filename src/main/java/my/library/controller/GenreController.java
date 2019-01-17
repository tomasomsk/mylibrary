package my.library.controller;

import my.library.dao.GenericDao;
import my.library.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GenreController {

    private GenericDao<Genre> genreDao;

    @GetMapping("/library/genres")
    public String getGenres(Model model) {
        List<Genre> genres = genreDao.findAll();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @GetMapping("/library/genres/*")
    public String showBook(@RequestParam(name="id") Long id, Model model) {
        Genre genre = genreDao.findById(id);
        model.addAttribute("genre", genre);
        return "genre";
    }

    @Autowired
    public void setGenreDao(GenericDao<Genre> genreDao) {
        this.genreDao = genreDao;
    }
}
