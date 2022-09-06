package com.example.restapitrainingfacility.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.*;


@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue
    private UUID id;


    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "midlename")
    private String midlename;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "deathdate")
    private String deathdate;

    @Column(name = "description")
    private String description;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "authors")

    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public Author(){
    }

    public Author(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Author(String firstname, String lastname, String midlename,
                  String birthdate, String deathdate,String description){
        this.firstname = firstname;
        this.lastname = lastname;
        this.midlename = midlename;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.description = description;
    }

    public UUID getId() {return id;}
    public String getFirstname() {return firstname;}
    public String getMidlename() {return midlename;}
    public String getBirthdate() {return birthdate;}
    public String getDeathdate() {return deathdate;}
    public String getDescription() {return description;}
    public Set<Book> getBooks() {return books;}
    public String getLastname() {return lastname;}
    public void setId(UUID id) {this.id = id;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setMidlename(String midlename) {this.midlename = midlename;}
    public void setBirthdate(String birthdate) {this.birthdate = birthdate;}
    public void setDeathdate(String deathdate) {this.deathdate = deathdate;}
    public void setDescription(String description) {this.description = description;}
    public void setBooks(Set<Book> books) {this.books = books;}
}
