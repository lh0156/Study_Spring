package com.oraclejava.day4.controller;

import com.oraclejava.day4.MovieService;
import com.oraclejava.day4.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value="/{title}")
    public String show(@PathVariable("title") String title, Model model) {
        List<Movie> movieList = movieService.findByTitle(title);
        model.addAttribute("movieList", movieList);
        return "show";
    }



}
