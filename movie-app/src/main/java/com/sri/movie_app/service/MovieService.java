package com.sri.movie_app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sri.movie_app.model.Movie;
import com.sri.movie_app.repository.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository){
        this.repository = repository;
    }

    public List<Movie> getMovies(int page, int size){
        Pageable pageable = PageRequest.of(page,size,Sort.by("title").ascending());
        Page<Movie> pages= repository.findAll(pageable); 
        return pages.getContent();
    }
}
