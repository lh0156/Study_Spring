package com.oraclejava.day4.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_cast")
public class MovieCast {
    //
    @EmbeddedId
    private MovieCastId movieCastId;
    @Column(name = "character_name")
    private String characterName;
    @Column(name = "cast_order")
    private Integer castOrder;

    @ManyToOne
    @JoinColumn(name="MOVIE_ID")
    private Movie movie;

    public MovieCastId getMovieCastId() {
        return movieCastId;
    }

    public void setMovieCastId(MovieCastId movieCastId) {
        this.movieCastId = movieCastId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Integer getCastOrder() {
        return castOrder;
    }

    public void setCastOrder(Integer castOrder) {
        this.castOrder = castOrder;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
