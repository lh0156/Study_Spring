package com.oraclejava.day4.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries(
        @NamedQuery(name=Movie.FIND_MOVIE_BY_TITLE,
            query = "select distinct(m) from Movie m " +
                    "left join fetch m.casts c " +
                    "where m.title like concat('%', :title, '%')")
)
public class Movie {

    public static final String FIND_MOVIE_BY_TITLE = "Movie.findByTitle";
    @Id
    @Column(name="movie_id")
    private Long movieId;
    private String title;
    private Long budget;
    private String homepage;
    private String overview;
    private Double popularity;
    @Column(name="release_date")
    private Date releaseDate;
    private Long revenue;
    private Integer runtime;
    @Column(name="movie_status")
    private String movieStatus;
    private String tagline;
    @Column(name="vote_average")
    private Double voteAverage;
    @Column(name="vote_count")
    private Long voteCount;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<MovieCast> casts = new HashSet<>();


    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public Set<MovieCast> getCasts() {
        return casts;
    }

    public void setCasts(Set<MovieCast> casts) {
        this.casts = casts;
    }
}
