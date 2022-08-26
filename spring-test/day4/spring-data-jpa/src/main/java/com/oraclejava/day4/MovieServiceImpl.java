package com.oraclejava.day4;

import com.oraclejava.day4.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("movieJpaService")
@Transactional
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }


}
