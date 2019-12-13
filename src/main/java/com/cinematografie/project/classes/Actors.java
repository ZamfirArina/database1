package com.cinematografie.project.classes;

public class Actors {
    private long id;
    private String name;
    private String placeOfBirts;
    private int age;
    private String movieReference;

    public Actors(long id, String name, String placeOfBirts, int age, String movieReference) {
        this.id = id;
        this.name = name;
        this.placeOfBirts = placeOfBirts;
        this.age = age;
        this.movieReference = movieReference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfBirts() {
        return placeOfBirts;
    }

    public void setPlaceOfBirts(String placeOfBirts) {
        this.placeOfBirts = placeOfBirts;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMovieReference() {
        return movieReference;
    }

    public void setMovieReference(String movieReference) {
        this.movieReference = movieReference;
    }
}