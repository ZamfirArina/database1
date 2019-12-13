package com.cinematografie.project.repositories;

import com.cinematografie.project.classes.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movies> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Movies",
                (reponse, rownumber) ->
                        new Movies(reponse.getLong("id"),
                                reponse.getString("genre"),
                                reponse.getString("title"),
                                reponse.getInt("year"),
                                reponse.getString("country"),
                                reponse.getString("staringRole")));
    }

    public Movies findById(long id) {
        String sql = "SELECT *FROM movies WHERE id = ?;";
        Object[] inputs = new Object[] {id};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) ->new Movies (reponse.getLong("id"),
                        reponse.getString("genre"),
                        reponse.getString("title"),
                        reponse.getInt("year"),
                        reponse.getString("country"),
                        reponse.getString("staringRole")));
    }

    public void save(Movies movies) {
        jdbcTemplate.update(
                "INSERT INTO Movies(genre, title, year, country, staringRole) VALUES(?,?,?,?,?)",
                movies.getGenre(), movies.getTitle(), movies.getYear(), movies.getCountry(), movies.getStaringRole());
    }

    public void update(Movies movies, String genre) {
        jdbcTemplate.update(
                "UPDATE Movies\n" +
                        "SET genre = ?, title = ?,year= ?,country = ?, staringRole = ?\n" +
                        "WHERE genre = ?",
                movies.getGenre(), movies.getTitle(), movies.getYear(), movies.getCountry(), movies.getStaringRole(),genre);
    }

    public void delete(String genre) {
        jdbcTemplate.update(
                "DELETE FROM Movies WHERE genre = ?", genre);
    }


}