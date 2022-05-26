package com.example.lab11.person;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {
    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private int id;

    private String nume;

    private int prieteni;

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPrieteni() {
        return prieteni;
    }

    public void setPrieteni(int prieteni) {
        this.prieteni = prieteni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return id == that.id && prieteni == that.prieteni && nume.equals(that.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prieteni);
    }
}
