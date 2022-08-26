package com.oraclejava.day4;

import com.oraclejava.day4.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findByTitle(String title);
}
