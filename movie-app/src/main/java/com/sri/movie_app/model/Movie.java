package com.sri.movie_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "movies")

public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public Movie(String description, String posterUrl, String publishedYear, String title) {
        this.description = description;
        this.posterUrl = posterUrl;
        this.publishedYear = publishedYear;
        this.title = title;
    }
    @Column(length = 1000)
    private String description;

    @Column
    private String posterUrl;

    @Column
    private String publishedYear;

    @Column
    private String title;

}
