package com.cinematografie.project.controllers;

import com.cinematografie.project.classes.Movies;
import com.cinematografie.project.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinematografie")
public class MoviesController {
    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("movies")
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @GetMapping("movies/{id}")
    public  Movies findById(@PathVariable long id){
        return moviesRepository.findById(id);
    }

    @PostMapping("movies")
    public void save(@RequestBody Movies movies) {
        moviesRepository.save(movies);
    }

    @PutMapping("movies/{genre}")
    public void update(@RequestBody Movies movies, @PathVariable String genre) {
        moviesRepository.update(movies,genre);
    }

    @DeleteMapping("movies/{genre}")
    public void delete(@PathVariable String genre) {
        moviesRepository.delete(genre);
    }
}