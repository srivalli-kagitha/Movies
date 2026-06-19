package com.sri.movie_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sri.movie_app.model.Movie;
import com.sri.movie_app.service.MovieService;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(@RequestParam int page,@RequestParam int size){
        return service.getMovies(page,size);
    }
}
