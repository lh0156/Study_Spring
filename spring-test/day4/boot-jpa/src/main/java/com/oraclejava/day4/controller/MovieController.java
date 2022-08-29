package com.oraclejava.day4.controller;

import com.oraclejava.day4.MovieService;
import com.oraclejava.day4.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/movies")
public class MovieController {

    private static Logger logger =
            LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String list() {
        return "show";
    }

    @GetMapping(value="/{title}")
    public String show(@PathVariable("title") String title,
                       Model model) {
        logger.info("show");
        List<Movie> movieList = movieService.findByTitle(title);
        model.addAttribute("movieList", movieList);
        return "show";
    }

    @GetMapping(value="/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        logger.info("detail");
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "detail";
    }

    @GetMapping(value="/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        logger.info("edit");
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "edit";
    }

    @PostMapping(value = "/update", params = "update")
    public String saveMovie(Movie movie) {
        logger.info("save movie");
        movieService.save(movie);
        return "redirect:/movies/detail/" + movie.getMovieId();
    }

    @PostMapping(value = "/update", params = "delete")
    public String deleteMovie(Movie movie) {
        logger.info("delete movie");
        movieService.remove(movie.getMovieId());
        return "redirect:/movies/detail/" + movie.getMovieId();
    }
}
