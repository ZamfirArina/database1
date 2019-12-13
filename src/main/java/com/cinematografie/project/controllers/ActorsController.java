package com.cinematografie.project.controllers;

import com.cinematografie.project.classes.Actors;
import com.cinematografie.project.repositories.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinematografie")
public class ActorsController {
    @Autowired
    ActorsRepository actorsRepository;

    @GetMapping("actors")
    public List<Actors> findAll() {
        return actorsRepository.findAll();
    }

    @GetMapping("actors/{id}")
    public  Actors findById(@PathVariable long id){
        return actorsRepository.findById(id);
    }

    @PostMapping("actors")
    public void save(@RequestBody Actors actors) {
        actorsRepository.save(actors);
    }

    @PutMapping("actors/{name}")
    public void update(@RequestBody Actors actors, @PathVariable String name) {
        actorsRepository.update(actors,name);
    }

    @DeleteMapping("actors/{name}")
    public void delete(@PathVariable String name) {
        actorsRepository.delete(name);
    }
}