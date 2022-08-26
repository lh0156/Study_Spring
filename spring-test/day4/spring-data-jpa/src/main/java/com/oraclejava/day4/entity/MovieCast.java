package com.oraclejava.day4.entity;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieCast {

    @Id
    @Column(name="movie_id")
    private long movieId;
    @Id
    @Column(name="person_id")
    private long personId;
    @Id
    @Column(name="gender_id")
    private long genderId;

    @Column(name = "character_name")
    private String characterName;
    @Column(name = "cast_order")
    private long castOrder;
}
