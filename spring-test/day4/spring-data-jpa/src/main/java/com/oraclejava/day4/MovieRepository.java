package com.oraclejava.day4;

import com.oraclejava.day4.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository
        extends CrudRepository<Movie, Long> {

//    @Query("select m from Movie m " +
//            "left join fetch m.casts c " +
//            "where m.title = :title")
    List<Movie> findByTitle(@Param("title") String title);
}
