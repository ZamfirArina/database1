package com.cinematografie.project.controllers;

import com.cinematografie.project.classes.Cinema;
import com.cinematografie.project.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinematografie")
public class CinemaController {
    @Autowired
    CinemaRepository cinemaRepository;

    @GetMapping("cinema")
    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @GetMapping("cinema/{id}")
    public  Cinema findById(@PathVariable long id){
        return cinemaRepository.findById(id);
    }

    @PostMapping("cinema")
    public void save(@RequestBody Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    @PutMapping("cinema/{firstName}")
    public void update(@RequestBody Cinema cinema, @PathVariable String nameCinema) {
        cinemaRepository.update(cinema,nameCinema);
    }

    @DeleteMapping("cinema/{nameCinema}")
    public void delete(@PathVariable String nameCinema) {
        cinemaRepository.delete(nameCinema);
    }
}