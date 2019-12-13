package com.cinematografie.project.repositories;

import com.cinematografie.project.classes.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cinema> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Cinema",
                (reponse, rownumber) ->
                        new Cinema(reponse.getLong("id"),
                                reponse.getString("nameCinema"),
                                reponse.getInt("contactNumber"),
                                reponse.getString("email"),
                                reponse.getString("street")));
    }

    public Cinema findById(long id) {
        String sql = "SELECT *FROM Cinema WHERE id = ?;";
        Object[] inputs = new Object[] {id};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) ->new Cinema(reponse.getLong("id"),
                        reponse.getString("nameCinema"),
                        reponse.getInt("contactNumber"),
                        reponse.getString("email"),
                        reponse.getString("street")));
    }


    public void save(Cinema cinema) {
        jdbcTemplate.update(
                "INSERT INTO Cinema(nameCinema, contactNumber, email, street) VALUES(?,?,?,?)",
                cinema.getNameCinema(), cinema.getContactNumber(), cinema.getEmail(), cinema.getStreet());
    }

    public void update(Cinema cinema, String nameCinema) {
        jdbcTemplate.update(
                "UPDATE Cinema \n" +
                        "SET nameCinema = ?, ContactNumber = ?,email = ?, street= ?\n" +
                        "WHERE nameCinema = ?",
                cinema.getNameCinema(), cinema.getContactNumber(), cinema.getEmail(), cinema.getStreet(),nameCinema);
    }

    public void delete(String nameCinema) {
        jdbcTemplate.update(
                "DELETE FROM Cinema WHERE nameCinema= ?", nameCinema);
    }
}