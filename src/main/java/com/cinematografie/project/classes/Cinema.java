package com.cinematografie.project.classes;

public class Cinema {
    private long id;
    private String nameCinema;
    private int contactNumber;
    private String email;
    private String street;


    public Cinema(long id, String nameCinema, int contactNumber, String email, String street) {
        this.id = id;
        this.nameCinema = nameCinema;
        this.contactNumber = contactNumber;
        this.email = email;
        this.street = street;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getNameCinema() {
        return nameCinema;
    }

    public void setNameCinema(String nameCinema) {
        this.nameCinema = nameCinema;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}