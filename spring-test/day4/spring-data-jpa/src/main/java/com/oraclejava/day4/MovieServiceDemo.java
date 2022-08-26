package com.oraclejava.day4;

import com.oraclejava.day4.config.JpaConfig;
import com.oraclejava.day4.entity.Movie;
import com.oraclejava.day4.entity.MovieCast;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.Set;

public class MovieServiceDemo {
    public static void main(String[] args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(JpaConfig.class);
        MovieService ms =
                ctx.getBean(MovieService.class);
        List<Movie> movieList = ms.findByTitle("Titanic");

        for (Movie movie : movieList) {
            System.out.println(movie.getMovieId()
                    + "," + movie.getTitle()
                    + "\n줄거리:" + movie.getOverview()
                    + "\n개봉일:" + movie.getReleaseDate());

            //캐스트 정보
            Set<MovieCast> castSet = movie.getCasts();

            for (MovieCast mc : castSet) {
                System.out.println(mc.getCharacterName());
            }

        }

        ctx.close();
    }
}
