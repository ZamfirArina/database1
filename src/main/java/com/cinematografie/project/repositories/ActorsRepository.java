package com.cinematografie.project.repositories;

import com.cinematografie.project.classes.Actors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Actors> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Actors",
                (reponse, rownumber) ->
                        new Actors(reponse.getLong("id"),
                                reponse.getString("name"),
                                reponse.getString("placeOfBirts"),
                                reponse.getInt("age"),
                                reponse.getString("movieReference")));
    }

    public Actors findById(long id) {
        String sql = "SELECT *FROM Actors WHERE id= ?;";
        Object[] inputs = new Object[] {id};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) ->new Actors (reponse.getLong("id"),
                        reponse.getString("name"),
                        reponse.getString("placeOfBirts"),
                        reponse.getInt("age"),
                        reponse.getString("movieReference")));
    }

    public void save(Actors actors) {
        jdbcTemplate.update(
                "INSERT INTO Actors(name, placeOfBirts, age, moviesReference) VALUES(?,?,?,?)",
                actors.getName(), actors.getPlaceOfBirts(), actors.getAge(), actors.getMovieReference());
    }

    public void update(Actors actors, String name) {
        jdbcTemplate.update(
                "UPDATE Actors \n" +
                        "SET name = ?, placeOfBirts = ? ,age = ? , movieReference = ?\n" +
                        "WHERE name = ?",
                actors.getName(), actors.getPlaceOfBirts(), actors.getAge(),actors.getMovieReference(),name);
    }

    public void delete(String name) {
        jdbcTemplate.update(
                "DELETE FROM  Actors WHERE name = ?", name );
    }
}