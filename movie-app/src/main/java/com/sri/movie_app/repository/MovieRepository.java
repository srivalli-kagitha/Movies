package com.sri.movie_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.movie_app.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}