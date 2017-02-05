package com.styshak.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "author")
@Access(AccessType.FIELD)
public class Author implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id == author.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
